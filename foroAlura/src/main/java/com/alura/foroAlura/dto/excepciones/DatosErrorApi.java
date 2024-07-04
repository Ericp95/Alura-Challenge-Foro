package com.alura.foroAlura.dto.excepciones;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public record DatosErrorApi(
		int codigoDeError,
		HttpStatus status,
		LocalDateTime fechaYHora,
		String mensaje,
		List<DatosErrorValidacion> errores) {

	public DatosErrorApi(int codigoDeError, HttpStatus status, Exception excepcion, List<DatosErrorValidacion> errores) {
		this(
				codigoDeError,
				status,
				LocalDateTime.now(),
				excepcion.getMessage(),
				errores
				);
	}
}