package com.relaciones.Controlador;

import com.relaciones.Modelo.Entidad.Categoria;
import com.relaciones.Modelo.Entidad.Cliente;
import com.relaciones.Servicios.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", service.listar());
        return "cliente/lista";
            }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/nueva")
    public String guardar(Model model){
        model.addAttribute("clientes", new Cliente());
        model.addAttribute("titulo","Registrar Cliente");
        return "cliente/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cliente")Cliente cliente) {
        service.guardar(cliente);
        return "redirect:/clientes";
    }
    @GetMapping("/editar/{id}")
    public String editarForm (@PathVariable Long id, Model model){
        model.addAttribute("cliente", service.buscarPorId(id));
        model.addAttribute("titulo","Actualizar Cliente");
        return "cliente/formulario";
    }

    @PostMapping("/Actualizar/{id}")
    public String editarForm(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        cliente.setIdCliente(id);
        service.actualizar(id, cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/clientes";
    }
}
