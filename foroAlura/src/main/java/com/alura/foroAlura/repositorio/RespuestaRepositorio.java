package com.alura.foroAlura.repositorio;

import foro.modelo.Respuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepositorio extends JpaRepository<Respuesta, Long> {

	Page<Respuesta> findAllByPublicacionId(Long publicacion_id, Pageable paginacion);
}