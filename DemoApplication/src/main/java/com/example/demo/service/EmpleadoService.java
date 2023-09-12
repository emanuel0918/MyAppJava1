package com.example.demo.service;

import com.example.demo.empleado.*;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {

    public String create (String stringID, String nombre) {
        int id;
        try {
            id = Integer.parseInt(stringID);
        } catch (NumberFormatException | NullPointerException nfe) {
            nfe.printStackTrace();
            return "Error en el Id";
        }

        //
        if (!"".equals(nombre)) {
            EmpleadoDAO.create(new Empleado(id, nombre));
            return "Empleado creado";
        }
        return "Error en el nombre";
    }
}