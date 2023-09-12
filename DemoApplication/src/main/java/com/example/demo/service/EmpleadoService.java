package com.example.demo.service;

import com.example.demo.empleado.*;

public class EmpleadoService {
    public final EmpleadoDAO empleadoDAO;

    public Empleado create (String stringID, String nombre) {
        int id;
        try {
            id = Integer.parseInt(stringID);
        } catch (NumberFormatException | NullPointerException nfe) {
            nfe.printStackTrace();
        }

        //
        if (!"".equals(nombre)) {
            return empleadoDAO.create(new Empleado(id, nombre))
        }
        return null;
    }
}