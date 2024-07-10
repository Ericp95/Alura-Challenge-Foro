package com.alura.foroAlura.modelo;

import foro.excepciones.InfoExcepcionesPersonalizadas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "respuestas", uniqueConstraints = { @UniqueConstraint(columnNames = { "mensaje", "publicacion_id" }, 
name = InfoExcepcionesPersonalizadas.RESPUESTA_MENSAJE_DUPLICADO) })
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	private Boolean solucion = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publicacion_id", nullable = false)
	private Publicacion publicacion;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario autor;
}