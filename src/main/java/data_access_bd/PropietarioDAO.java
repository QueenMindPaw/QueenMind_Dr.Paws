package data_access_bd;

import Model.owner;
import jakarta.servlet.ServletContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public owner save(owner owner) throws Exception{
        System.out.println(owner.getId_propietario());
        if(owner.getId_propietario() == -1){
            //que vamos a hacer para que el password sea seguro
            
            //pues que se inserte
            this.insertStatement.setString(1, owner.getCorreo());
            this.insertStatement.setString(2, owner.getNombre());
            this.insertStatement.setString(3, owner.getAppat());
            this.insertStatement.setString(4, owner.getApmat());
            this.insertStatement.setString(5, owner.getDir());
            this.insertStatement.setString(6, owner.getPassword());
            
            int idPropietario = this.insertStatement.executeUpdate();
            System.out.println("id del propietario es " + idPropietario);
            
            owner.setId_propietario(idPropietario);
            
            return owner;
        }else{
            //actualiar
            //this.insertStatement.setString(1, propietario.getCorreo());
            this.updateStatement.setString(1, owner.getNombre());
            this.updateStatement.setString(2, owner.getAppat());
            this.updateStatement.setString(3, owner.getApmat());
            this.updateStatement.setString(4, owner.getDir());
            //this.insertStatement.setString(6, propietario.getPassword());
            this.updateStatement.setInt(5, owner.getId_propietario());
            
            this.updateStatement.executeUpdate();
            
            return owner;
            
        }
    }
    
    //consulta general
    public List<owner> getAll() throws Exception{
        List<owner> ownerLista = new ArrayList<>();
        
        ResultSet rs = this.selectAllStatement.executeQuery();
        
        while(rs.next()){
            owner owner = new owner(
                    rs.getInt("id_propietario"),
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir"),
                    rs.getString("password")
                    
            );
            
            ownerLista.add(owner);
        }
        return ownerLista;
    }
    
    public owner getbyId(int idPropietario) throws Exception{
        
        this.selectByIdStatement.setInt(1, idPropietario);
        
        ResultSet rs = this.selectByIdStatement.executeQuery();
        
        if(rs.next()){
            owner owner = new owner(
                   
                    rs.getInt("id_propietario"), 
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir")
            );
            
            return owner;
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
    public owner login(owner owner) throws SQLException {
        this.selectLoginStatement.setString(1, owner.getCorreo());
        ResultSet rs = this.selectLoginStatement.executeQuery();
        
        if(rs.next() && rs.getString("password")!=null){
            owner.getPassword();
            rs.getString("password");
            
            System.out.println("Funciona wiiii");
            
            owner ownerLogin = new owner(
                    rs.getInt("id_propietario"),
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir"),
                    rs.getString("password")
            );
            
            return ownerLogin;
            
        }
        return null;
        
    }
    
    
    
}
