package com.alura.foroAlura.excepciones;

public class TransaccionSobreEntidadInexistenteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TransaccionSobreEntidadInexistenteException(String mensaje) {
		super(mensaje);
	}
}