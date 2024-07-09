package com.alura.foroAlura.repositorio;

import foro.modelo.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {

	Page<Publicacion> findAllByCursoId(Long cursoId, Pageable paginacion);
}