/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author alumno
 */
public class Documento extends BDObject{
    
    private int mascota_id;
    private String nombre;
    private String descripcion;
    private Byte[] archivo;

    public Documento(){
    }
    
    public Documento(int mascota_id, String nombre, String descripcion, Byte[] archivo) {
        super();
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public Documento(int mascota_id, String nombre, String descripcion, Byte[] archivo, int id) {
        super(id);
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public int getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(Byte[] archivo) {
        this.archivo = archivo;
    }
    
    
    
}
