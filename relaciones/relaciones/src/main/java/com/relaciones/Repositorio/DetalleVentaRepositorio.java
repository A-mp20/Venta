package com.relaciones.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.Modelo.Entidad.DetalleVenta;

public interface DetalleVentaRepositorio extends JpaRepository<DetalleVenta, Long> {
}
