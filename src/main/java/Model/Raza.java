/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author alumno
 */
public class Raza extends BDObject{
    private String nombre;
    
    public Raza(){
    
    }

    public Raza(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Raza(String nombre, int id) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
