/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author alumno
 */
public class Cita extends BDObject {
    
    private int mascota_id;
    private int veterinario_id;
    private String descripcion;
    private Timestamp fecha;
    private Timestamp fecha_creacion;
    private Timestamp fecha_modificacion;
    
    public Cita(){
    }
    
    public Cita(int mascota_id, int veterinario_id, String descripcion, Timestamp fecha, Timestamp fecha_creacion, Timestamp fecha_modificacion) {
        super();
        this.mascota_id = mascota_id;
        this.veterinario_id = veterinario_id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Cita(int mascota_id, int veterinario_id, String descripcion, Timestamp fecha, Timestamp fecha_creacion, Timestamp fecha_modificacion, int id) {
        super(id);
        this.mascota_id = mascota_id;
        this.veterinario_id = veterinario_id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public int getVeterinario_id() {
        return veterinario_id;
    }

    public void setVeterinario_id(int veterinario_id) {
        this.veterinario_id = veterinario_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
    
    
}
