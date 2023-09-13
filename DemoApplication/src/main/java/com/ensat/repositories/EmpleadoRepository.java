package com.ensat.repositories;

import com.ensat.entities.Empleado;
import org.springframework.data.jpa.repository.*;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
