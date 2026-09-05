package com.relaciones.Controlador;

import com.relaciones.Modelo.Entidad.Categoria;
import com.relaciones.Servicios.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
         model.addAttribute("categorias", service.listar());
         return "categoria/Lista";
    }

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/nueva")
    public String guardar(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("titulo", "Crear Nueva Categoría");
        return "categoria/Formulario";
    }

    @PostMapping("/Guardar")
    public String guardar(@ModelAttribute("categorias")Categoria categoria) {
        service.guardar(categoria);
        return  "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        // Debes buscar la entidad existente por su ID
        model.addAttribute("categoria", service.buscarPorId(id));
        model.addAttribute("titulo", "Editar Categoría");
        return "categoria/Formulario";
    }

    // 1. ACTUALIZAR (Procesado mediante POST desde el formulario)
    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute("categoria") Categoria categoria) {
        categoria.setIdCategoria(id); // Asignamos el ID para asegurar la actualización
        service.actualizar(id, categoria);
        return "redirect:/categorias"; // Redirige a la lista
    }

    // 2. ELIMINAR (Procesado mediante un enlace GET)
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/categorias"; // Redirige a la lista tras eliminar
    }
}

