package com.alura.foroAlura.modelo;

import foro.excepciones.InfoExcepcionesPersonalizadas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Etiqueta")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "etiquetas", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre" },
name = InfoExcepcionesPersonalizadas.CATEGORIA_NOMBRE_DUPLICADO) })
public class Etiqueta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private Nivel nivel;

	@ManyToOne
	@JoinColumn(name = "etiqueta_padre_id")
	private Etiqueta etiquetaPadre;

	@OneToMany(mappedBy="etiquetaPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Etiqueta> etiquetasHijas = new ArrayList<>();

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Publicacion> publicaciones = new ArrayList<>();
}