package com.example.demo.api;
import com.example.demo.empleado.Empleado;
import com.example.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private EmpleadoService myService;


    @PostMapping("/create")
    @ResponseBody
    public String createResource(
            @RequestParam("id") String id,
            @RequestParam("name") String name) {
        
        // StringID
        return myService.create(id, name);
        
    }
}
