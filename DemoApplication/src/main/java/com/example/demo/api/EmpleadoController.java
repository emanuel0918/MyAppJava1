package com.example.demo.api;

import com.example.demo.empleado.Empleado;
import com.example.demo.empleado.EmpleadoDAO;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Empleado controller.
 */
@RestController("/empleado")
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class EmpleadoController {



    /**
     * Nuevo empleado.
     *
     * @param nombre
     * @return
     */
    @RequestMapping("empleado/create")
    public Object nuevoEmpleado(@RequestParam("nombre") String nombre) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        Empleado e = new Empleado(nombre);
        try {
            empleadoDAO.create(e);
            return e.toString();
        } catch (Exception ex) {
            LoggerFactory.getLogger("").debug("");
        }
        return "";
    }

    /**
     * List all empleados.
     *
     * @param model
     * @return
     */
    @GetMapping("empleado/list")
    public List<Empleado> list(Model model) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> list = null;
        try {
            list =
                    empleadoDAO.getAll();
        } catch (Exception e) {
            LoggerFactory.getLogger("").debug("");
        }
        return list;
    }

    /**
     * View a specific empleado by its uuid.
     *
     * @param uuid
     * @return
     */
    @GetMapping("empleado/{uuid}")
    public Object getEmpleado(@PathVariable String uuid) {
        try {

            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            return empleadoDAO.get(uuid);
        } catch (Exception e) {
            LoggerFactory.getLogger("").debug("");
        }
        return "";

    }

    /**
     * Edit empleado by its uuid.
     *
     * @param uuid
     * @return
     */
    @PutMapping("/empleado/edit/{uuid}")
    public Object edit(@PathVariable String uuid, @RequestParam("nombre") String nombre) {
        return "";
    }



    /**
     * Delete empleado by its uuid.
     *
     * @param uuid
     * @return
     */
    @DeleteMapping("empleado/delete/{uuid}")
    public Object delete(@PathVariable String uuid ) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        try {
            empleadoDAO.delete(uuid);
        } catch(Exception e) {
            LoggerFactory.getLogger("").debug("");
        }
        return "";
    }

}