package com.relaciones.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("titulo", "¡Bienvenido a Spring Boot!");
        model.addAttribute("mensaje", "Esta vista viene directamente desde el servidor.");
        return "index";
    }

}
