package com.ensat.services;

import com.ensat.entities.Empleado;
import com.ensat.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Empleado service implement.
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public Optional create(String nombre) {
        Empleado e = new Empleado();
        if (!"".equals(nombre)) {
            e.setNombre(nombre);
            e.setFechaCreacion(System.currentTimeMillis());
            e.setFechaModificacion(System.currentTimeMillis());
            empleadoRepository.save(e);
        }
        return get(e);
    }

    @Override
    public Optional get(Empleado e) {
        int id = e.getId();
        return empleadoRepository.findById(id);
    }

    @Override
    public List<Empleado> getAll() {
        List<Empleado> list = empleadoRepository.findAll(
                Sort.by(Sort.Direction.DESC, "fechaModificacion")
        );
        return list;
    }

    @Override
    public Optional update(Empleado e) {
        if (!"".equals(e.getNombre())) {
            e.setNombre(e.getNombre());
            e.setFechaModificacion(System.currentTimeMillis());
        }
        empleadoRepository.save(e);
        return get(e);
    }

    @Override
    public void delete(Empleado e) {
        empleadoRepository.delete(e);
    }



}
