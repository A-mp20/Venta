package com.relaciones.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.relaciones.Modelo.Entidad.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
