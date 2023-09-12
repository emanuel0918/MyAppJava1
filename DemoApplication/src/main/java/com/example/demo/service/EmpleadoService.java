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

    public void create (String stringID, String nombre) {
        int id;
        try {
            id = Integer.parseInt(stringID);
        } catch (NumberFormatException | NullPointerException nfe) {
            nfe.printStackTrace();
        }

        //
        if (!"".equals(nombre)) {
            return EmpleadoDAO.create(new Empleado(id, nombre));
        }
    }
}