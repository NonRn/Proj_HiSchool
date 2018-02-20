/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Meen
 */
public class ConnectionBuilder {
    public static Connection getConnection()  {
        Connection con = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            Properties prop = new Properties();
            InputStream input = classloader.getResourceAsStream("db-connection.properties");
        
            System.out.println("Input"+input);
            prop.load(input);
            
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String driver = prop.getProperty("driver");
            
            Class.forName(driver);
            System.out.println("Driver loaded success");

            con = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }
}
