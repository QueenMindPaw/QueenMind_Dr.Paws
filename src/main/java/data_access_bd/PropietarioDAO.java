/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_bd;

import Model.Mascota;
import Model.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author alumno
 */
public class PropietarioDAO {
    
      private Connection connection;
      
      private PreparedStatement insertStatement, updateStatement, 
            selectAllStatement, selectByIdStatement, 
              selectLoginStatement, deleteByIdStatement;
      
      private final String insertQuery = 
            "INSERT INTO propietario(correo, nombre, appat, apmat, dir, password) "
            + "VALUES (?,?,?,?,?,?)";
    
    private final String updateQuery = 
            "UPDATE propietario SET nombre = ?, appat = ?, "
            + "apmat = ?, dir = ? WHERE id_propietario = ?";
    
    private final String deleteQuery = 
            "DELETE FROM propietario WHERE id_propietario = ?";
    
    private final String selectAllQuery = 
            "SELECT * FROM propietario";
    
    private final String selectByIdQuery = 
            "SELECT * FROM propietario WHERE id_propietario = ?";
    
    private final String selectLogin = 
            "SELECT * FROM propietario WHERE correo = ?";
    
    
    
    public PropietarioDAO(Connection connection, ServletContext context){
        this.connection = connection;
        
        try{
            this.insertStatement = 
                    this.connection.prepareStatement(
                            this.insertQuery, 
                            Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = 
                    this.connection.prepareStatement(this.updateQuery);
            this.deleteByIdStatement = 
                    this.connection.prepareStatement(this.deleteQuery);
            this.selectAllStatement = 
                    this.connection.prepareStatement(this.selectAllQuery);
            
            this.selectByIdStatement =
                    this.connection.prepareStatement(this.selectByIdQuery);
            this.selectLoginStatement = 
                    this.connection.prepareStatement(this.selectLogin);
        }catch(Exception e){
            System.out.println("Error en el crud");
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public Propietario save(Propietario propietario) throws Exception{
        System.out.println(propietario.getId_propietario());
        if(propietario.getId_propietario() == -1){
            //que vamos a hacer para que el password sea seguro
            
            //pues que se inserte
            this.insertStatement.setString(1, propietario.getCorreo());
            this.insertStatement.setString(2, propietario.getNombre());
            this.insertStatement.setString(3, propietario.getAppat());
            this.insertStatement.setString(4, propietario.getApmat());
            this.insertStatement.setString(5, propietario.getDir());
            this.insertStatement.setString(6, propietario.getPassword());
            
            int idPropietario = this.insertStatement.executeUpdate();
            System.out.println("id del propietario es " + idPropietario);
            
            propietario.setId_propietario(idPropietario);
            
            return propietario;
        }else{
            //actualiar
            //this.insertStatement.setString(1, propietario.getCorreo());
            this.updateStatement.setString(1, propietario.getNombre());
            this.updateStatement.setString(2, propietario.getAppat());
            this.updateStatement.setString(3, propietario.getApmat());
            this.updateStatement.setString(4, propietario.getDir());
            //this.insertStatement.setString(6, propietario.getPassword());
            this.updateStatement.setInt(5, propietario.getId_propietario());
            
            this.updateStatement.executeUpdate();
            
            return propietario;
            
        }
    }
    
    //consulta general
    public List<Propietario> getAll() throws Exception{
        List<Propietario> propietarioLista = new ArrayList<>();
        
        ResultSet rs = this.selectAllStatement.executeQuery();
        
        while(rs.next()){
            Propietario propietario = new Propietario(
                    rs.getInt("id_propietario"),
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir"),
                    rs.getString("password")
                    
            );
            
            propietarioLista.add(propietario);
        }
        return propietarioLista;
    }
    
    public Propietario getbyId(int idPropietario) throws Exception{
        
        this.selectByIdStatement.setInt(1, idPropietario);
        
        ResultSet rs = this.selectByIdStatement.executeQuery();
        
        if(rs.next()){
            Propietario propietario = new Propietario(
                   
                    rs.getInt("id_propietario"), 
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir")
            );
            
            return propietario;
        }
        return null;
    }
    
    //metodo para borrar
    public boolean delete(int idPropietario) throws Exception{
        this.deleteByIdStatement.setInt(1, idPropietario);
        //aqui ejecuto la actualizacion para el borrado y debe devolver true o false
        this.deleteByIdStatement.executeUpdate();
        return true;
    }
    
    //para verificar el usuario 
    public Propietario login(Propietario propietario) throws SQLException {
        this.selectLoginStatement.setString(1, propietario.getCorreo());
        ResultSet rs = this.selectLoginStatement.executeQuery();
        
        if(rs.next() && rs.getString("password")!=null){
            propietario.getPassword();
            rs.getString("password");
            
            System.out.println("Funciona wiiii");
            
            Propietario propietarioLogin = new Propietario(
                    rs.getInt("id_propietario"),
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir"),
                    rs.getString("password")
            );
            
            return propietarioLogin;
            
        }
        return null;
        
    }
    
    
    
}
