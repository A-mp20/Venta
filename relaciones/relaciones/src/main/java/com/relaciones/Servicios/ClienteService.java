package com.relaciones.Servicios;

import org.springframework.stereotype.Service;

import com.relaciones.Modelo.Entidad.Cliente;
import com.relaciones.Repositorio.ClienteRepositorio;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepositorio repository;

    public ClienteService(ClienteRepositorio repository) {
        this.repository = repository;
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));
    }

    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente) {

        Cliente existente = buscarPorId(id);

        existente.setNombre(cliente.getNombre());

        return repository.save(existente);
    }

    public void eliminar(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }

        repository.deleteById(id);
    }
}
