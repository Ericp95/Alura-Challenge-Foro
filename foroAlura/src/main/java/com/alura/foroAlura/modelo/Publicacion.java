package com.alura.foroAlura.modelo;

import foro.excepciones.InfoExcepcionesPersonalizadas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Publicacion")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "publicaciones", uniqueConstraints = { @UniqueConstraint(columnNames = { "titulo", "mensaje" }, 
name = InfoExcepcionesPersonalizadas.PUBLICACION_TITULO_MENSAJE_DUPLICADO) })
public class Publicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "mensaje", nullable = false)
	private String mensaje;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoPublicacion estado = EstadoPublicacion.NO_RESPONDIDO;

	@OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Respuesta> respuestas = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id")
	private Etiqueta curso;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario autor;

	public int calcularTotalRespuestas() {
		return this.respuestas.size();
	}

}