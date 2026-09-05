package com.relaciones.Servicios;

import com.relaciones.Modelo.Entidad.DetalleVenta;
import com.relaciones.Modelo.Entidad.Producto;
import com.relaciones.Modelo.Entidad.Venta;
import com.relaciones.Repositorio.DetalleVentaRepositorio;
import com.relaciones.Repositorio.ProductoRepositorio;
import com.relaciones.Repositorio.VentaRepositorio;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DetalleVentaService {

    private final DetalleVentaRepositorio detalleRepository;
    private final VentaRepositorio ventaRepository;
    private final ProductoRepositorio productoRepository;

    public DetalleVentaService(
            DetalleVentaRepositorio detalleRepository,
            VentaRepositorio ventaRepository,
            ProductoRepositorio productoRepository) {

        this.detalleRepository = detalleRepository;
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
    }

    public List<DetalleVenta> listar() {
        return detalleRepository.findAll();
    }

    public DetalleVenta buscarPorId(Long id) {
        return detalleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Detalle no encontrado"));
    }

    public DetalleVenta guardar(DetalleVenta detalle) {

        Venta venta = ventaRepository
                .findById(detalle.getVenta().getIdVenta())
                .orElseThrow(() ->
                        new RuntimeException("Venta no encontrada"));

        Producto producto = productoRepository
                .findById(detalle.getProducto().getIdProducto())
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        detalle.setVenta(venta);
        detalle.setProducto(producto);

        if (detalle.getPrecioVenta() == 0) {
            detalle.setPrecioVenta(producto.getPrecio());
        }

        return detalleRepository.save(detalle);
    }

    public DetalleVenta actualizar(
            Long id,
            DetalleVenta detalle) {

        DetalleVenta existente = buscarPorId(id);

        Venta venta = ventaRepository
                .findById(detalle.getVenta().getIdVenta())
                .orElseThrow(() ->
                        new RuntimeException("Venta no encontrada"));

        Producto producto = productoRepository
                .findById(detalle.getProducto().getIdProducto())
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        existente.setCantidad(detalle.getCantidad());
        existente.setPrecioVenta(detalle.getPrecioVenta());
        existente.setVenta(venta);
        existente.setProducto(producto);

        return detalleRepository.save(existente);
    }

    public void eliminar(Long id) {

        if (!detalleRepository.existsById(id)) {
            throw new RuntimeException("Detalle no encontrado");
        }

        detalleRepository.deleteById(id);
    }

}
