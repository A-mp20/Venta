package com.relaciones.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.Modelo.Entidad.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Long> {
}
