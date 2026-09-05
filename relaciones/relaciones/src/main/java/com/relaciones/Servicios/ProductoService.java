package com.relaciones.Servicios;

import org.springframework.stereotype.Service;

import com.relaciones.Modelo.Entidad.Categoria;
import com.relaciones.Modelo.Entidad.Producto;
import com.relaciones.Repositorio.CategoriaRepository;
import com.relaciones.Repositorio.ProductoRepositorio;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepositorio productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepositorio productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;   
        this.categoriaRepository = categoriaRepository;
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));
    }

    public Producto guardar(Producto producto) {
         Long idCategoria =
                producto.getCategoria().getIdCategoria();

        Categoria categoria = categoriaRepository
                .findById(idCategoria)
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));

        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto producto) {

        Producto existente = buscarPorId(id);

        Categoria categoria = categoriaRepository
                .findById(producto.getCategoria().getIdCategoria())
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));

        existente.setNombre(producto.getNombre());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setCategoria(categoria);

        return productoRepository.save(existente);
    }

    public void eliminar(Long id) {

        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }

        productoRepository.deleteById(id);
    }
}
