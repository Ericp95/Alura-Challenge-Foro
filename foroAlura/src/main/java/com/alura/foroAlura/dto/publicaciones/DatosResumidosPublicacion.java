package com.alura.foroAlura.dto.publicaciones;

import foro.modelo.EstadoPublicacion;
import foro.modelo.Publicacion;

import java.time.LocalDateTime;

public record DatosResumidosPublicacion(
		Long publicacionId,
		String titulo,
		String mensaje,
		LocalDateTime fechaCreacion,
		EstadoPublicacion estado,
		int totalRespuestas,
		Long cursoId
	) {

	public DatosResumidosPublicacion(Publicacion publicacion) {
		this(
				publicacion.getId(),
				publicacion.getTitulo(),
				publicacion.getMensaje(),
				publicacion.getFechaCreacion(),
				publicacion.getEstado(),
				publicacion.calcularTotalRespuestas(),
				publicacion.getCurso().getId()
				);
	}
}