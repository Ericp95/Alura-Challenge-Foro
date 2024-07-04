package com.alura.foroAlura.dto.excepciones;

import foro.excepciones.PertenenciaInvalidaExcepcion;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record DatosErrorPertenenciaInvalida(
		int codigoDeError,
		HttpStatus status,
		LocalDateTime fechaYHora,
		String mensaje) {

	public DatosErrorPertenenciaInvalida(PertenenciaInvalidaExcepcion excepcion) {
		this(400, HttpStatus.BAD_REQUEST, LocalDateTime.now(), excepcion.getMessage());
	}
}