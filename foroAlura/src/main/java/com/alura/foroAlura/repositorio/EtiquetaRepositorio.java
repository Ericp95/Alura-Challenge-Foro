package com.alura.foroAlura.repositorio;

import foro.modelo.Etiqueta;
import foro.modelo.Nivel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepositorio extends JpaRepository<Etiqueta, Long>  {

	Page<Etiqueta> findAllByNivel(Nivel nivel, Pageable paginacion);

	Etiqueta findByIdAndNivel(Long id, Nivel nivel);

	boolean existsByIdAndNivel(Long id, Nivel nivel);

	Page<Etiqueta> findAllByNivelAndEtiquetaPadreId(Nivel nivel, Long etiquetaPadreId, Pageable paginacion);

}