package com.alura.foroAlura.dto.publicaciones;

import foro.dto.respuestas.DatosResumidosRespuesta;
import foro.dto.usuarios.DatosResumidosUsuario;
import foro.modelo.EstadoPublicacion;
import foro.modelo.Publicacion;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListadoPublicacionPorCurso(
		Long publicacionId, 
		String titulo, 
		String mensaje, 
		LocalDateTime fechaCreacion, 
		EstadoPublicacion estado, 
		List<DatosResumidosRespuesta> respuestas,
		DatosResumidosUsuario autor
		) {

	public DatosListadoPublicacionPorCurso(Publicacion publicacion) {
		this(
				publicacion.getId(), 
				publicacion.getTitulo(), 
				publicacion.getMensaje(), 
				publicacion.getFechaCreacion(), 
				publicacion.getEstado(), 
				publicacion.getRespuestas().stream().map(DatosResumidosRespuesta::new).toList(),
				new DatosResumidosUsuario(publicacion.getAutor())
			);
	}
}