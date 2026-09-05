package com.relaciones.Controlador;

import com.relaciones.Modelo.Entidad.DetalleVenta;
import com.relaciones.Servicios.DetalleVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleVenta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DetalleVenta buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public DetalleVenta guardar(
            @RequestBody DetalleVenta detalle) {

        return service.guardar(detalle);
    }

    @PutMapping("/{id}")
    public DetalleVenta actualizar(
            @PathVariable Long id,
            @RequestBody DetalleVenta detalle) {

        return service.actualizar(id, detalle);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return "Detalle eliminado correctamente";
    }
}
