/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.empleado;

/**
 *
 * @author Emanuel
 */
public class Empleado {
    private String uuid;
    private String nombre;
    
    public Empleado() {}
    
    
    
    //public Empleado ()

    public Empleado (String nombre) {
        this.uuid = java.util.UUID.randomUUID().toString();
        this.nombre = nombre;
    }
    public Empleado(String uuid, String nombre) {
        this.uuid = uuid;
        this.nombre = nombre;
    }

    // BD
    public String toCsvString () {
        return uuid + "," + nombre ;
    }
    
    @Override
    public String toString() {
        return  uuid + ", " + nombre ;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}