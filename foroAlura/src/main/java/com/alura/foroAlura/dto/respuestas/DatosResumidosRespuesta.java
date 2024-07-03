package com.alura.foroAlura.dto.respuestas;

import foro.modelo.Respuesta;

import java.time.LocalDateTime;

public record DatosResumidosRespuesta(Long id, String mensaje, LocalDateTime fechaCreacion, Boolean solucion) {

	public DatosResumidosRespuesta(Respuesta respuesta) {
		this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(), respuesta.getSolucion());		
	}
}