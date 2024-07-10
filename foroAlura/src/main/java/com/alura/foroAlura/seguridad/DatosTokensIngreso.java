package com.alura.foroAlura.seguridad;

public record DatosTokensIngreso(
		DatosCompletosToken accessToken, 
		DatosCompletosToken refreshToken
		) {
}