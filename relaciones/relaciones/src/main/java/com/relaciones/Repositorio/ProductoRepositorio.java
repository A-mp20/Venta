package com.relaciones.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.Modelo.Entidad.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
