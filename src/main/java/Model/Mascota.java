/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 *
 * @author alumno
 */
public class Mascota extends BDObject{
    private int propietario_id;
    private int raza_id;
    private Timestamp nacimiento;
    private String nombre;
    private Blob imagen;
    private int tamano;
    private int peso;
    private String sexo;
    
    public Mascota(){
    }
    
    public Mascota(int propietario_id, int raza_id, Timestamp nacimiento, String nombre, Blob imagen, int tamano, int peso, String sexo) {
        super();
        this.propietario_id = propietario_id;
        this.raza_id = raza_id;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tamano = tamano;
        this.peso = peso;
        this.sexo = sexo;
    }

    public Mascota(int id, int propietario_id, int raza_id, Timestamp nacimiento, String nombre, Blob imagen, int tamano, int peso, String sexo) {
        super(id);
        this.propietario_id = propietario_id;
        this.raza_id = raza_id;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tamano = tamano;
        this.peso = peso;
        this.sexo = sexo;
    }

    public int getPropietario_id() {
        return propietario_id;
    }

    public void setPropietario_id(int propietario_id) {
        this.propietario_id = propietario_id;
    }

    public int getRaza_id() {
        return raza_id;
    }

    public void setRaza_id(int raza_id) {
        this.raza_id = raza_id;
    }

    public Timestamp getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Timestamp nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
