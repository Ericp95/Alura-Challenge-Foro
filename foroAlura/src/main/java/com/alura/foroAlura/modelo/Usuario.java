package com.alura.foroAlura.modelo;

import foro.excepciones.InfoExcepcionesPersonalizadas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = { "correo" }, 
name = InfoExcepcionesPersonalizadas.USUARIO_CORREO_DUPLICADO) })
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String correo;
	private String contrasena;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuarios_roles", 
	joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"),
    inverseJoinColumns=@JoinColumn(name="rol_id", referencedColumnName = "id")) 
	private List<Rol> roles = new ArrayList<>();

	@OneToMany(mappedBy = "autor")
	private List<Publicacion> publicaciones = new ArrayList<>();
	
	@OneToMany(mappedBy = "autor")
	private List<Respuesta> respuestas = new ArrayList<>();
}