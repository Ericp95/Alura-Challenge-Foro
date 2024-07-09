package com.alura.foroAlura.repositorio;

import foro.modelo.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Boolean existsByCorreo(String correo);

	Optional<Usuario> findByCorreo(String correo);

	@Transactional
	@Modifying
	void deleteByCorreo(String correo);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Usuario u SET u.contrasena = ?1 WHERE u.id = ?2")
	void changePassword(String nuevaContrasena, Long usuarioId);
}