package data_access_bd;

import jakarta.servlet.ServletContext;

import java.sql.*;

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
                String password = context.getInitParameter("Erizo312aszxd!");
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

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println("Error al cerrar la conexion");
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}
