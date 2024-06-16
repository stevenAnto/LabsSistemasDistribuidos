package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Conexionsql {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost/bd_Proyecto";
    String usuario = "postgres";
    String clave = "1234";
    
    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa", "conexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion Fallida" + e, "conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void desconectar() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Desconexion Exitosa", "deconexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Desconexion Fallida" + e, "deconexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    

}
