package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kasettilameri
 */
public class DbCon {
    
    public Connection con;
    
    public Connection getCon(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://10.114.32.28:3306/MySqueal", "Roska", "Asoor");
            System.out.println("Connected to the database");
            
        } catch (ClassNotFoundException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } catch (SQLException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return con;
        }
}