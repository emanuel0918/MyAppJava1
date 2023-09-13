package com.ensat.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = dd/mm/yyyy )


}
