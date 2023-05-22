/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author alumno
 */
public class Veterinario extends Persona {
    private String cedula;
    
    public Veterinario(){
    }

    public Veterinario(String cedula, int id, String nombre, String apellido_paterno, String apellido_materno, String telefono, String email) {
        super(id, nombre, apellido_paterno, apellido_materno, telefono, email);
        this.cedula = cedula;
    }

    public Veterinario(String cedula, String nombre, String apellido_paterno, String apellido_materno, String telefono, String email) {
        super(nombre, apellido_paterno, apellido_materno, telefono, email);
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}
