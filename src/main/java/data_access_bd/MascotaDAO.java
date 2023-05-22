/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_bd;

import Model.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class MascotaDAO {
    
    private Connection connection;
    
    private PreparedStatement insertStatement, updateStatement, 
            selectAllStatement, selectByIdStatement;
    
    private final String insertQuery = 
            "INSERT INTO mascotas(propietario_id, raza_id, "
            + "nacimiento, nombre, imagen, tamano, sexo, peso) "
            + "VALUES (?,?,?,?,?,?,?,?)";
    
    private final String updateQuery = 
            "UPDATE mascotas SET propietario_id = ?, raza_id = ?, "
            + "nacimiento = ?, nombre = ?, imagen = ?, tamano = ?, "
            + "sexo = ?, peso = ? WHERE id = ?";
    
    private final String selectAllQuery = 
            "SELECT * FROM mascotas";
    
    private final String selectByIdQuery = 
            "SELECT * FROM mascotas WHERE id = ?";
    
    public MascotaDAO(Connection connection){
        this.connection = connection;
        
        try{
            this.insertStatement = 
                    this.connection.prepareStatement(
                            this.insertQuery, 
                            Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = 
                    this.connection.prepareStatement(this.updateQuery);
            this.selectAllStatement = 
                    this.connection.prepareStatement(this.selectAllQuery);
            
            this.selectByIdStatement =
                    this.connection.prepareStatement(this.selectByIdQuery);
        }catch(Exception e){
            System.out.println("Error en el crud");
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public Mascota save(Mascota mascota) throws Exception{
        if(mascota.getId() == -1){
            //pues que se inserte
            this.insertStatement.setInt(1, mascota.getPropietario_id());
            this.insertStatement.setInt(2, mascota.getRaza_id());
            this.insertStatement.setTimestamp(3, mascota.getNacimiento());
            this.insertStatement.setString(4, mascota.getNombre());
            this.insertStatement.setBlob(5, mascota.getImagen());
            this.insertStatement.setInt(6, mascota.getTamano());
            this.insertStatement.setString(7, mascota.getSexo());
            this.insertStatement.setInt(8, mascota.getPeso());
            
            int idMascota = this.insertStatement.executeUpdate();
            mascota.setId(idMascota);
            
            return mascota;
        }else{
            //actualiar
            this.updateStatement.setInt(1, mascota.getPropietario_id());
            this.updateStatement.setInt(2, mascota.getRaza_id());
            this.updateStatement.setTimestamp(3, mascota.getNacimiento());
            this.updateStatement.setString(4, mascota.getNombre());
            this.updateStatement.setBlob(5, mascota.getImagen());
            this.updateStatement.setInt(6, mascota.getTamano());
            this.updateStatement.setString(7, mascota.getSexo());
            this.updateStatement.setInt(8, mascota.getPeso());
            this.updateStatement.setInt(9, mascota.getId());
            
            this.updateStatement.executeUpdate();
            
            return mascota;
            
        }
    }
    
    //consulta general
    public List<Mascota> getAll() throws Exception{
        List<Mascota> mascotaLista = new ArrayList<>();
        
        ResultSet rs = this.selectAllStatement.executeQuery();
        
        while(rs.next()){
            Mascota mascota = new Mascota(
                    rs.getInt("id"),
                    rs.getInt("propietario_id"), 
                    rs.getInt("raza_id"),
                    rs.getTimestamp("nacimiento"),
                    rs.getString("nombre"),
                    rs.getBlob("imagen"),
                    rs.getInt("tamano"),
                    rs.getInt("peso"),
                    rs.getString("sexo")
            );
            
            mascotaLista.add(mascota);
        }
        return mascotaLista;
    }
    
    
    public Mascota getbyId(int idMascota) throws Exception{
        
        this.selectByIdStatement.setInt(1, idMascota);
        
        ResultSet rs = this.selectByIdStatement.executeQuery();
        
        if(rs.next()){
            Mascota mascota = new Mascota(
                    rs.getInt("id"),
                    rs.getInt("propietario_id"), 
                    rs.getInt("raza_id"),
                    rs.getTimestamp("nacimiento"),
                    rs.getString("nombre"),
                    rs.getBlob("imagen"),
                    rs.getInt("tamano"),
                    rs.getInt("peso"),
                    rs.getString("sexo")
            );
            
            return mascota;
        }
        return null;
    }
}
