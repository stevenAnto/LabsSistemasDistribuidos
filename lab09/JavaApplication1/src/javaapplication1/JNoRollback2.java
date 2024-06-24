/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author stv
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author stv
 */
public class JNoRollback2 {
    public static void main(String[] args) {
        Connection connection = DataBase.getConnection();
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        try {
            connection.setAutoCommit(false);//Se agrupan en una sola transaccion
            stmt1 = connection.prepareStatement("INSERT INTO mitabla VALUES( ?, ? );");
            stmt2 = connection.prepareStatement("INSERT INTO miotratabla VALUES( ?, ?, ? );");
            
            System.out.println( "Primer INSERT tabla [miTabla] " );
            stmt1.setString(1, "000001");
            stmt1.setString(2, "micorreo@mail.com");
            stmt1.executeUpdate();
            System.out.println( "Segundo INSERT tabla [miTabla] " );
            stmt1.setString(1, "000002");
            stmt1.setString(2, "amayuya@mail.com");
            stmt1.executeUpdate();
            System.out.println( "Tercer INSERT tabla [miTabla] " );
            stmt1.setString(1, "000003");
            stmt1.setString(2, "diosdado@mail.com");
            stmt1.executeUpdate();
            System.out.println( "Primer INSERT tabla [miOtraTabla]" );
            stmt2.setString(1, "Juan");
            stmt2.setString(2, "Perez");
            //stmt2.setInt(3, 99); //Tipo de dato CORRECTO INT
            stmt2.setString(3, "Hola soy un error");//Tipo de dato INCORRECTO
            stmt2.executeUpdate();
            connection.commit();
        }catch(SQLException ex){
            System.err.println("ERROR: " + ex.getMessage());
            if(connection!=null){
                System.out.println("Rollback");
                try{
                    connection.rollback();//deshace todo los cambiso realizdos
                }catch(SQLException ex1){
                    System.err.println( "No se pudo deshacer" + ex1.getMessage() );
                }
            }
        }finally{
            System.out.println( "cierra conexion a la base de datos" );
            try{
                if(stmt1!=null) stmt1.close();
                if(stmt2!=null) stmt2.close();
                if(connection!=null) connection.close();
            }catch(SQLException ex){
                System.err.println( ex.getMessage() );
            }
        }
        

    }

}

