import java.io.*;
import java.net.*;
import java.sql.*;

public class Servidor {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root"; // Cambia esto por tu usuario de MySQL
    private static final String PASS = "elbasurita"; // Cambia esto por tu contraseña de MySQL

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor escuchando en el puerto 12345...");
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private Connection connection;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String command;
                while ((command = input.readLine()) != null) {
                    String[] tokens = command.split(";");
                    String action = tokens[0];

                    switch (action) {
                        case "INSERTAR_DEPARTAMENTO":
                            insertarDepartamento(tokens, output);
                            break;
                        case "ACTUALIZAR_DEPARTAMENTO":
                            actualizarDepartamento(tokens, output);
                            break;
                        case "ELIMINAR_DEPARTAMENTO":
                            eliminarDepartamento(tokens, output);
                            break;
                        case "INSERTAR_PROYECTO":
                            insertarProyecto(tokens, output);
                            break;
                        case "ACTUALIZAR_PROYECTO":
                            actualizarProyecto(tokens, output);
                            break;
                        case "ELIMINAR_PROYECTO":
                            eliminarProyecto(tokens, output);
                            break;
                        case "INSERTAR_INGENIERO":
                            insertarIngeniero(tokens, output);
                            break;
                        case "ACTUALIZAR_INGENIERO":
                            actualizarIngeniero(tokens, output);
                            break;
                        case "ELIMINAR_INGENIERO":
                            eliminarIngeniero(tokens, output);
                            break;
                        case "INSERTAR_PARTICIPACION":
                            insertarParticipacion(tokens, output);
                            break;
                        case "ELIMINAR_PARTICIPACION":
                            eliminarParticipacion(tokens, output);
                            break;
                        case "CONSULTAR_PROYECTOS_DEPARTAMENTO":
                            consultarProyectosPorDepartamento(tokens, output);
                            break;
                        case "CONSULTAR_INGENIEROS_PROYECTO":
                            consultarIngenierosPorProyecto(tokens, output);
                            break;
                        default:
                            output.println("Comando no reconocido");
                            break;
                    }
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                    socket.close();
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        private void insertarDepartamento(String[] tokens, PrintWriter output) {
            String nombre = tokens[1];
            String telefono = tokens[2];
            String fax = tokens[3];
            try (CallableStatement cs = connection.prepareCall("{CALL InsertarDepartamento(?, ?, ?)}")) {
                cs.setString(1, nombre);
                cs.setString(2, telefono);
                cs.setString(3, fax);
                cs.executeUpdate();
                output.println("Departamento insertado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al insertar departamento");
            }
        }

        private void actualizarDepartamento(String[] tokens, PrintWriter output) {
            int id = Integer.parseInt(tokens[1]);
            String nombre = tokens[2];
            String telefono = tokens[3];
            String fax = tokens[4];
            try (CallableStatement cs = connection.prepareCall("{CALL ActualizarDepartamento(?, ?, ?, ?)}")) {
                cs.setInt(1, id);
                cs.setString(2, nombre);
                cs.setString(3, telefono);
                cs.setString(4, fax);
                cs.executeUpdate();
                output.println("Departamento actualizado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al actualizar departamento");
            }
        }

        private void eliminarDepartamento(String[] tokens, PrintWriter output) {
            int id = Integer.parseInt(tokens[1]);
            try (CallableStatement cs = connection.prepareCall("{CALL EliminarDepartamento(?)}")) {
                cs.setInt(1, id);
                cs.executeUpdate();
                output.println("Departamento eliminado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al eliminar departamento");
            }
        }

        private void insertarProyecto(String[] tokens, PrintWriter output) {
            String nombre = tokens[1];
            String fechaInicio = tokens[2];
            String fechaTermino = tokens[3];
            int idDepartamento = Integer.parseInt(tokens[4]);
            try (CallableStatement cs = connection.prepareCall("{CALL InsertarProyecto(?, ?, ?, ?)}")) {
                cs.setString(1, nombre);
                cs.setString(2, fechaInicio);
                cs.setString(3, fechaTermino);
                cs.setInt(4, idDepartamento);
                cs.executeUpdate();
                output.println("Proyecto insertado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al insertar proyecto");
            }
        }

        private void actualizarProyecto(String[] tokens, PrintWriter output) {
            int id = Integer.parseInt(tokens[1]);
            String nombre = tokens[2];
            String fechaInicio = tokens[3];
            String fechaTermino = tokens[4];
            int idDepartamento = Integer.parseInt(tokens[5]);
            try (CallableStatement cs = connection.prepareCall("{CALL ActualizarProyecto(?, ?, ?, ?, ?)}")) {
                cs.setInt(1, id);
                cs.setString(2, nombre);
                cs.setString(3, fechaInicio);
                cs.setString(4, fechaTermino);
                cs.setInt(5, idDepartamento);
                cs.executeUpdate();
                output.println("Proyecto actualizado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al actualizar proyecto");
            }
        }

        private void eliminarProyecto(String[] tokens, PrintWriter output) {
            int id = Integer.parseInt(tokens[1]);
            try (CallableStatement cs = connection.prepareCall("{CALL EliminarProyecto(?)}")) {
                cs.setInt(1, id);
                cs.executeUpdate();
                output.println("Proyecto eliminado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al eliminar proyecto");
            }
        }

        private void insertarIngeniero(String[] tokens, PrintWriter output) {
            String nombre = tokens[1];
            String especialidad = tokens[2];
            String cargo = tokens[3];
            try (CallableStatement cs = connection.prepareCall("{CALL InsertarIngeniero(?, ?, ?)}")) {
                cs.setString(1, nombre);
                cs.setString(2, especialidad);
                cs.setString(3, cargo);
                cs.executeUpdate();
                output.println("Ingeniero insertado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al insertar ingeniero");
            }
        }

        private void actualizarIngeniero(String[] tokens, PrintWriter output) {
            int id = Integer.parseInt(tokens[1]);
            String nombre = tokens[2];
            String especialidad = tokens[3];
            String cargo = tokens[4];
            try (CallableStatement cs = connection.prepareCall("{CALL ActualizarIngeniero(?, ?, ?, ?)}")) {
                cs.setInt(1, id);
                cs.setString(2, nombre);
                cs.setString(3, especialidad);
                cs.setString(4, cargo);
                cs.executeUpdate();
                output.println("Ingeniero actualizado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al actualizar ingeniero");
            }
        }

        private void eliminarIngeniero(String[] tokens, PrintWriter output) {
            int id = Integer.parseInt(tokens[1]);
            try (CallableStatement cs = connection.prepareCall("{CALL EliminarIngeniero(?)}")) {
                cs.setInt(1, id);
                cs.executeUpdate();
                output.println("Ingeniero eliminado");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al eliminar ingeniero");
            }
        }

        private void insertarParticipacion(String[] tokens, PrintWriter output) {
            int idIngeniero = Integer.parseInt(tokens[1]);
            int idProyecto = Integer.parseInt(tokens[2]);
            try (CallableStatement cs = connection.prepareCall("{CALL InsertarParticipacion(?, ?)}")) {
                cs.setInt(1, idIngeniero);
                cs.setInt(2, idProyecto);
                cs.executeUpdate();
                output.println("Participación insertada");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al insertar participación");
            }
        }

        private void eliminarParticipacion(String[] tokens, PrintWriter output) {
            int idIngeniero = Integer.parseInt(tokens[1]);
            int idProyecto = Integer.parseInt(tokens[2]);
            try (CallableStatement cs = connection.prepareCall("{CALL EliminarParticipacion(?, ?)}")) {
                cs.setInt(1, idIngeniero);
                cs.setInt(2, idProyecto);
                cs.executeUpdate();
                output.println("Participación eliminada");
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al eliminar participación");
            }
        }

        private void consultarProyectosPorDepartamento(String[] tokens, PrintWriter output) {
            int idDepartamento = Integer.parseInt(tokens[1]);
            try (CallableStatement cs = connection.prepareCall("{CALL ConsultarProyectosPorDepartamento(?)}")) {
                cs.setInt(1, idDepartamento);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    output.println("ID: " + rs.getInt("id_proyecto") + ", Nombre: " + rs.getString("nombre_proyecto"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al consultar proyectos por departamento");
            }
        }

        private void consultarIngenierosPorProyecto(String[] tokens, PrintWriter output) {
            int idProyecto = Integer.parseInt(tokens[1]);
            try (CallableStatement cs = connection.prepareCall("{CALL ConsultarIngenierosPorProyecto(?)}")) {
                cs.setInt(1, idProyecto);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    output.println("ID: " + rs.getInt("id_ingeniero") + ", Nombre: " + rs.getString("nombre_ingeniero"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                output.println("Error al consultar ingenieros por proyecto");
            }
        }
    }
}
