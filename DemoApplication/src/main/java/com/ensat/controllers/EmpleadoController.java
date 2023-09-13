package com.ensat.controllers;

import com.ensat.entities.Empleado;
import com.ensat.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Empleado nuevoEmpleado(@RequestParam("nombre") String nombre) {
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
     * @param model
     * @return
     */
    @GetMapping("empleado/{id}")
    public Empleado getEmpleado(@PathVariable Integer id, Model model) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        return empleadoService.get(empleado);
    }

    @PutMapping("/empleado/edit/{id}")
    public Object edit(@PathVariable Integer id, @RequestParam("nombre") String nombre) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        if (empleadoService.get(empleado) == null) {
            return "Empleado no encontrado";
        }

        //
        empleado.setNombre(nombre);
        return  empleadoService.update(empleado).toString();
    }



    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id ) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        if (empleadoService.get(empleado) == null) {
            return "Empleado no encontrado";
        }
        empleadoService.delete(empleado);
        return "Empleado eliminado";
    }

}
