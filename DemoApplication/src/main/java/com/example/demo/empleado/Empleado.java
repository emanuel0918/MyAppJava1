/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.empleado;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Emanuel
 */
public class Empleado {

    private int id;
    private String nombre;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fechaCreacion;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date fechaModificacion;


    
    public Empleado() {}
    
    
    
    //public Empleado ()

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        //
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

        // Convert Instant to Date
        this.fechaCreacion = Date.from(instant);
        this.fechaModificacion = fechaCreacion;
    }

    public Empleado(int id, String nombre, Date fechaCreacion, Date fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    // BD
    public String toCsvString () {
        return id + "," + nombre ;
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}