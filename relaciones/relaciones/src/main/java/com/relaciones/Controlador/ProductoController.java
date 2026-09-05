package com.relaciones.Controlador;

import com.relaciones.Modelo.Entidad.Producto;
import com.relaciones.Servicios.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return service.guardar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable Long id,
            @RequestBody Producto producto) {

        return service.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return "Producto eliminado correctamente";
    }
}
