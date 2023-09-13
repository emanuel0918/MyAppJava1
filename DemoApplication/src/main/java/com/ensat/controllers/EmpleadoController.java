package com.ensat.controllers;

import com.ensat.entities.Empleado;
import com.ensat.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Empleado controller.
 */
@RestController("/empleado")
public class EmpleadoController {
     @Autowired
     private EmpleadoService empleadoService;



    /**
     * Nuevo empleado.
     *
     * @param nombre
     * @return
     */
    @RequestMapping("empleado/create")
    public Optional nuevoEmpleado(@RequestParam("nombre") String nombre) {
        return empleadoService.create(nombre);
    }

    /**
     * List all empleados.
     *
     * @param model
     * @return
     */
    @GetMapping("empleado/list")
    public List<Empleado> list(Model model) {
        return empleadoService.getAll();
    }

    /**
     * View a specific empleado by its id.
     *
     * @param id
     * @return
     */
    @GetMapping("empleado/{id}")
    public Object getEmpleado(@PathVariable Integer id) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        return empleadoService.get(empleado);
    }

    @PutMapping("/empleado/edit/{id}")
    public Object edit(@PathVariable Integer id, @RequestParam("nombre") String nombre) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        if (!empleadoService.get(empleado).isPresent()) {
            return "Empleado no encontrado";
        }

        //
        empleado.setNombre(nombre);
        return  empleadoService.update(empleado);
    }



    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @DeleteMapping("empleado/delete/{id}")
    public String delete(@PathVariable Integer id ) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        if (!empleadoService.get(empleado).isPresent()) {
            return "Empleado no encontrado";
        }
        empleadoService.delete(empleado);
        return "Empleado eliminado";
    }

}
