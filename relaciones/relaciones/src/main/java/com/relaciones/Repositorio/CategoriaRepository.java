package com.relaciones.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relaciones.Modelo.Entidad.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
