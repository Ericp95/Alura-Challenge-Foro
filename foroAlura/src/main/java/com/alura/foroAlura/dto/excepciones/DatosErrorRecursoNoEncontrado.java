package com.alura.foroAlura.dto.excepciones;

import foro.excepciones.RecursoNoEncontradoException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record DatosErrorRecursoNoEncontrado(
		int codigoDeError,
		HttpStatus status,
		LocalDateTime fechaYHora,
		String mensaje) {

	public DatosErrorRecursoNoEncontrado(RecursoNoEncontradoException excepcion) {
		this(404, HttpStatus.NOT_FOUND, LocalDateTime.now(), excepcion.getMessage());		
	}
}