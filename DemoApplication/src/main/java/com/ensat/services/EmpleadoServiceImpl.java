package com.ensat.services;

import com.ensat.entities.Empleado;
import com.ensat.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Empleado service implement.
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public Empleado create(String nombre) {
        Empleado e = new Empleado();
        if (!"".equals(nombre)) {
            e.setNombre(nombre);
            e.setFechaCreacion(System.currentTimeMillis());
            e.setFechaModificacion(e.getFechaCreacion());
            empleadoRepository.save(e);
        }
        return get(e);
    }

    @Override
    public Empleado get(Empleado e) {
        int id = e.getId();
        return empleadoRepository.getById(id);
    }

    @Override
    public List<Empleado> getAll() {
        List<Empleado> list = empleadoRepository.findAll(
                Sort.by(Sort.Direction.DESC, "fechaModificacion")
        );
        return list;
    }


}
