package Model;

import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private DBConnection(){

    }

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Erizo312aszxd!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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
