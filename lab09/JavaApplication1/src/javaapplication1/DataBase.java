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
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @web https://www.jc-mouse.net/
 * @author Mouse
 */
public class DataBase {

    private final static String bd = "laboratorio09";
    private final static String login = "root";
    private final static String password = "Archi~123";
    private final static String url = "jdbc:mysql://localhost/" + bd;

    public static Connection getConnection() {
        System.out.println("Entrando al metodo");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("1");
            Connection conn = DriverManager.getConnection(url, login, password);
            System.out.println("2");
            if (conn != null) {
                System.out.println("Conectado a la base de datos [" + bd + "]");
            }
            return conn;
        } catch (SQLException e) {
            System.err.println("sql exception"+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("clase no encontrada "+e.getMessage());
        }
        return null;
    }
}
