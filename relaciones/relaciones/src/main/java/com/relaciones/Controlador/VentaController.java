package com.relaciones.Controlador;

import com.relaciones.Modelo.Entidad.Venta;
import com.relaciones.Servicios.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Venta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Venta buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return service.guardar(venta);
    }

    @GetMapping("/Editar/{id}")
    public Venta actualizar(
            @PathVariable Long id,
            @RequestBody Venta venta) {

        return service.actualizar(id, venta);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return "Venta eliminada correctamente";
    }
}
