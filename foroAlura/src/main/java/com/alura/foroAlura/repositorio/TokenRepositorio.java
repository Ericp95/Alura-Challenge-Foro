package com.alura.foroAlura.repositorio;

import foro.modelo.RefreshToken;
import foro.modelo.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface TokenRepositorio extends JpaRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByToken(String refreshToken);

	@Transactional
	@Modifying
	void deleteByUsuario(Usuario usuario);
}