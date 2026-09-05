package com.relaciones.Servicios;

import org.springframework.stereotype.Service;

import com.relaciones.Modelo.Entidad.Categoria;
import com.relaciones.Repositorio.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));
    }

    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria actualizar(Long id, Categoria categoria) {

        Categoria existente = buscarPorId(id);

        existente.setNombre(categoria.getNombre());

        return repository.save(existente);
    }

    public void eliminar(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada");
        }

        repository.deleteById(id);
    }
}
