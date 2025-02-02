package com.alura.foroAlura.dto.respuestas;

import foro.dto.usuarios.DatosResumidosUsuario;
import foro.modelo.Respuesta;

import java.time.LocalDateTime;

public record DatosCompletosRespuesta(
		Long id, 
		String mensaje, 
		LocalDateTime fechaCreacion, 
		Boolean solucion, 
		Long publicacion_id,
		DatosResumidosUsuario autor) {

	public DatosCompletosRespuesta(Respuesta respuesta) {
		this(
				respuesta.getId(),
				respuesta.getMensaje(),
				respuesta.getFechaCreacion(),
				respuesta.getSolucion(),
				respuesta.getPublicacion().getId(),
				new DatosResumidosUsuario(respuesta.getAutor()));		
	}
}