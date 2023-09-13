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
    public Empleado newProduct(@RequestParam("nombre") String nombre) {
        return empleadoService.create(nombre);
    }

    /**
     * List all empleados.
     *
     * @param model
     * @return
     */
    @GetMapping("/")
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
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        Empleado empleado = new Empleado();
        empleado.setId(id);
        model.addAttribute("product", empleadoService.get(empleado));
        return "productshow";
    }

}
