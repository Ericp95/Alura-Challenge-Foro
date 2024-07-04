package com.alura.foroAlura.dto.excepciones;

import foro.excepciones.TransaccionSobreEntidadInexistenteException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record DatosErrorIdDeEntidadInvalido(
		int codigoDeError,
		HttpStatus status,
		LocalDateTime fechaYHora,
		String mensaje
		) {

	public DatosErrorIdDeEntidadInvalido(TransaccionSobreEntidadInexistenteException excepcion) {
		this(400, HttpStatus.BAD_REQUEST, LocalDateTime.now(), excepcion.getMessage());		
	}
}