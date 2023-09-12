/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Empleado;

/**
 *
 * @author Emanuel
 */
public class Empleado {
    private int id;
    private String nombre;
    
    public Empleado() {}
    
    
    
    //public Empleado ()

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    
    
}