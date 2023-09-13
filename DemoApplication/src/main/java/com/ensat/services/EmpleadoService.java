package com.ensat.services;

import com.ensat.entities.Empleado;

import java.util.List;

public interface EmpleadoService {

    public Empleado create(String nombre);

    public Empleado get(Empleado e);

    public List<Empleado> getAll();

    public Empleado update(Empleado e);

    public void delete (Empleado e);


}
