package com.alura.foroAlura.dto.excepciones;

import foro.excepciones.CambioDeEstadoInvalidoException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record DatosErrorCambioDeEstadoInvalido(
		int codigoDeError,
		HttpStatus status,
		LocalDateTime fechaYHora,
		String mensaje) {

	public DatosErrorCambioDeEstadoInvalido(CambioDeEstadoInvalidoException excepcion) {
		this(400, HttpStatus.BAD_REQUEST, LocalDateTime.now(), excepcion.getMessage());		
	}
}