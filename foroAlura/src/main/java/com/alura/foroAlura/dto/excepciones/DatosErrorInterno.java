package com.alura.foroAlura.dto.excepciones;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record DatosErrorInterno(
		int codigoDeError,
		HttpStatus status,
		LocalDateTime fechaYHora,
		String mensaje) {

	public DatosErrorInterno(Exception excepcion) {
		this(
				500, 
				HttpStatus.INTERNAL_SERVER_ERROR, 
				LocalDateTime.now(), 
				"Algo salió mal... Por favor, intenta más tarde.");
	}
}