/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sql.Conexionsql;

/**
 *
 * @author USER
 */
public class DepartamentoFrame extends javax.swing.JFrame {

    /**
     * Creates new form DepartamentoFrame
     */
    public DepartamentoFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Insertar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_Actualizar = new javax.swing.JButton();
        btn_Visualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Limpiar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Ver = new javax.swing.JTable();
        Text_ID = new javax.swing.JTextField();
        Text_Name = new javax.swing.JTextField();
        Text_tel = new javax.swing.JTextField();
        Text_fax = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Insertar.setText("Insertar");
        btn_Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertarActionPerformed(evt);
            }
        });

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("DEPARTAMENTOS");
        jLabel1.setIconTextGap(8);

        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });

        btn_Visualizar.setText("Visualizar");
        btn_Visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VisualizarActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        jLabel3.setText("Nombre: ");

        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });

        Ver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(Ver);

        Text_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_IDActionPerformed(evt);
            }
        });

        jLabel4.setText("TEL");

        jLabel5.setText("FAX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Limpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btn_Insertar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Eliminar)
                                .addGap(88, 88, 88))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(40, 40, 40)
                                        .addComponent(Text_fax, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)
                                        .addComponent(Text_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btn_Actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Visualizar)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Text_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(Text_fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addComponent(btn_Limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Eliminar)
                        .addComponent(btn_Insertar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Actualizar)
                        .addComponent(btn_Visualizar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertarActionPerformed
        Connection conn = null;
        Statement st = null;
        String url = "jdbc:postgresql://localhost/proyecto_empresa2";
        String usuario = "postgres";
        String clave = "12345";
        try {
            String nombre = Text_Name.getText(); // Obtener el valor del campo Nombre
            String telefono = Text_tel.getText(); // Obtener el valor del campo Teléfono
            String fax = Text_fax.getText(); // Obtener el valor del campo Fax Obtener el valor del campo Fax
            conn = DriverManager.getConnection(url, usuario, clave);
            
            String insertar = "INSERT INTO public.departamento (Nombre, Telefono, Fax) VALUES ('" + nombre + "','" + telefono + "','" + fax + "')";
            st = conn.createStatement();
            st.executeUpdate(insertar);
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Inserción Exitosa", "Insertar", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e, "Insertar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_InsertarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        Connection conn = null;
        Statement st = null;
        String url = "jdbc:postgresql://localhost/bd_Proyecto";
        String usuario = "postgres";
        String clave = "1234";
        try {
            conn = DriverManager.getConnection(url, usuario, clave);
            String delete = "DELETE FROM public.departamento WHERE id_departamento='" + Text_ID.getText() + "'";
            st = conn.createStatement();
            st.executeUpdate(delete);
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Eliminado Exitoso", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Eliminar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        Connection conn = null;
        PreparedStatement st = null;
        String url = "jdbc:postgresql://localhost/bd_Proyecto";
        String usuario = "postgres";
        String clave = "1234";

        try {
            String id = Text_ID.getText(); // Obtener el valor del campo ID
            String nombre = Text_Name.getText(); // Obtener el valor del campo Nombre

            conn = DriverManager.getConnection(url, usuario, clave);

            // Construir la consulta parametrizada con PreparedStatement
            String update = "UPDATE public.departamento SET nombre = ? WHERE id_departamento = ?";
            st = conn.prepareStatement(update);
            st.setString(1, nombre); // Establecer el valor del nombre
            st.setString(2, id); // Establecer el valor del ID

            int filasActualizadas = st.executeUpdate();
            System.out.println("Filas actualizadas: " + filasActualizadas);

            JOptionPane.showMessageDialog(null, "Actualización Exitosa", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage(), "Actualizar", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar recursos en bloques finally
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void btn_VisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VisualizarActionPerformed
        Connection conn = null;
        Statement leer = null;
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        Ver.setModel(tabla);
        String[] datos = new String[2];
        try {
            String url = "jdbc:postgresql://localhost/bd_Proyecto";
            String usuario = "postgres";
            String clave = "1234";
            conn = DriverManager.getConnection(url, usuario, clave);
            leer = conn.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT nombre, id_departamento FROM public.departamento ");
            while (resultado.next()) {
                datos[1] = resultado.getString(1);
                datos[0] = resultado.getString(2);
                tabla.addRow(datos);
            }
            Ver.setModel(tabla);
            leer.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e, "Insertar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_VisualizarActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        Text_ID.setText("");
        Text_Name.setText("");
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void Text_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_IDActionPerformed

    }//GEN-LAST:event_Text_IDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DepartamentoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartamentoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartamentoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartamentoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartamentoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Text_ID;
    private javax.swing.JTextField Text_Name;
    private javax.swing.JTextField Text_fax;
    private javax.swing.JTextField Text_tel;
    private javax.swing.JTable Ver;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Insertar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Visualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}