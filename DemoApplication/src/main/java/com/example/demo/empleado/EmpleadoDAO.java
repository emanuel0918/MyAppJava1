/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.empleado;

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

/**
 * @author Emanuel
 */
public class EmpleadoDAO {

    final static String csvFilePath = "C:\\Users\\Emanuel\\MyAppJava1\\DemoApplication\\empleado.csv";

    public Empleado create(Empleado empleado) throws Exception {
        FileWriter writer = new FileWriter(csvFilePath, true);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.newLine();
        buffer.write(empleado.toCsvString());
        //
        //buffer.newLine();
        return get(empleado.getUuid());
    }

    public Empleado get(String uuid) throws Exception {
        List<Empleado> empleados = getAll();
        for (Empleado e : empleados) {
            if (uuid.equals(e.getUuid())) {
                return e;
            }
        }
        throw new Exception();
    }

    public List<Empleado> getAll() throws Exception {
        List<Empleado> empleados = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String uuid = parts[0];
                String nombre = parts[1];
                Empleado empleado = new Empleado(
                        nombre
                );
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    // Delete an Empleado by its unique index idCarrera
    public void delete(String uuid) throws Exception {
        List<Empleado> empleados = getAll();
        Empleado empleado = null;

        // Find the Escuela with the specified idCarrera
        for (Empleado e1 : empleados) {
            if (uuid.equals(e1.getUuid())) {
                empleado = e1;
                break;
            }
        }

        if (empleado != null) {
            // Remove the Escuela from the list
            empleados.remove(empleado);

            // Backup the original CSV file
            EmpleadoDAO.backupCsvFile();

            // Clear the contents of the CSV file
            EmpleadoDAO.clearCsvFile();

            // Write the updated list of Escuelas back to the CSV file
            for (Empleado e2 : empleados) {
                create(e2);
            }
        }
    }

    // Backup the original CSV file by copying it to a backup file
    private static void backupCsvFile() {
        try {
            String backupFilePath = csvFilePath + ".backup";
            Files.copy(Paths.get(csvFilePath), Paths.get(backupFilePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clear the contents of the CSV file
    private static void clearCsvFile() {
        try (FileWriter writer = new FileWriter(csvFilePath, false)) {
            // Simply open and close the file to clear its contents
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}