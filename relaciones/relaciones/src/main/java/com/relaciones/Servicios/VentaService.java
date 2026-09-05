package com.relaciones.Servicios;

import com.relaciones.Modelo.Entidad.Cliente;
import com.relaciones.Modelo.Entidad.Venta;
import com.relaciones.Repositorio.ClienteRepositorio;
import com.relaciones.Repositorio.VentaRepositorio;


import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class VentaService {
    private final VentaRepositorio ventaRepository;
    private final ClienteRepositorio clienteRepository;

    public VentaService(
            VentaRepositorio ventaRepository,
            ClienteRepositorio clienteRepository) {

        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    public Venta buscarPorId(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Venta no encontrada"));
    }

    public Venta guardar(Venta venta) {

        Cliente cliente = clienteRepository
                .findById(venta.getCliente().getIdCliente())
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        venta.setCliente(cliente);

        if (venta.getFecha() == null) {
            venta.setFecha(null);
        }

        return ventaRepository.save(venta);
    }

    public Venta actualizar(Long id, Venta venta) {

        Venta existente = buscarPorId(id);

        Cliente cliente = clienteRepository
                .findById(venta.getCliente().getIdCliente())
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        existente.setCliente(cliente);
        existente.setFecha(venta.getFecha());
        existente.setTotal(venta.getTotal());

        return ventaRepository.save(existente);
    }

    public void eliminar(Long id) {

        if (!ventaRepository.existsById(id)) {
            throw new RuntimeException("Venta no encontrada");
        }

        ventaRepository.deleteById(id);
    }

}
