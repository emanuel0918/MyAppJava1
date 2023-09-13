package com.ensat.services;

import com.ensat.entities.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    public Optional create(String nombre);

    public Optional get(Empleado e);

    public List<Empleado> getAll();

    public Optional update(Empleado e);

    public void delete (Empleado e);



}
