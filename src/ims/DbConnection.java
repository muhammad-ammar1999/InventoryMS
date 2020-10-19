/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**  
 *
 * @author bilal
 */
public class DbConnection {

    private static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/ShopMS?zeroDateTimeBehavior=convertToNull";
    private static String user = "root";
    private static String pass = "";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            System.err.println("Error: " + cnfe.getMessage());
        }

        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn != null && !conn.isClosed()) {
            return conn;
        } 
        connect();
        return conn;

    } 

    public static ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        ResultSet rs = c.createStatement().executeQuery(query);
        return rs;
    }
    public static int executeUpdate(String query) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        int rowsAffected = c.createStatement().executeUpdate(query);
        return rowsAffected;
    }
}
