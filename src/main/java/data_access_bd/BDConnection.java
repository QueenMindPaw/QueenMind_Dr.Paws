/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_bd;

/**
 *
 * @author alumno
 */

import java.sql.*;
import javax.servlet.ServletContext;

public class BDConnection {
    
    private static Connection connection;
    
    //definimos el constructor de la clase
    private BDConnection(){
    
    }
    
    public static Connection getConnection(ServletContext context){
        if(connection == null){
            try{
                String url = context.getInitParameter("http://localhost:3306");
                String user = context.getInitParameter("root");
                String password = context.getInitParameter("n0m3l0");
                //definimos el driver de mysql
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(url, user, password);
                
                
            }catch(SQLException | ClassNotFoundException e){
                System.out.println("No conecto a la BD");
                System.out.println("Error : " + e.getMessage());
                
            }
        }
        return connection;
    }
    
}
