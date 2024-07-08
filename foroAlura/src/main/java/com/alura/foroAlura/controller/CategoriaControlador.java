package com.alura.foroAlura.controller;

import foro.dto.etiquetas.categorias.DatosCompletosCategoria;
import foro.dto.etiquetas.categorias.DatosGuardarCategoria;
import foro.dto.etiquetas.categorias.DatosResumidosCategoria;
import foro.servicios.EtiquetaServicio;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaControlador {

	@Autowired
	private EtiquetaServicio etiquetaServicio;

	@GetMapping
	public ResponseEntity<Page<DatosResumidosCategoria>> listarCategorias(@PageableDefault(size = 25) Pageable paginacion) {
		var pagina = etiquetaServicio.listarCategorias(paginacion);
		return ResponseEntity.ok(pagina);
	}

	@GetMapping("/{categoriaId}")
	public ResponseEntity<DatosCompletosCategoria> encontrarCategoriaPorId(@PathVariable Long categoriaId) {
		DatosCompletosCategoria categoria = etiquetaServicio.encontrarCategoriaPorId(categoriaId);
		return ResponseEntity.ok(categoria);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<DatosResumidosCategoria> crearCategoria(
			@RequestBody
			@Valid
			DatosGuardarCategoria datosCategoria,

			UriComponentsBuilder uriComponentsBuilder) {

		DatosResumidosCategoria categoria = etiquetaServicio.crearCategoria(datosCategoria);

		URI url = uriComponentsBuilder.path("categorias/{categoriaId}").buildAndExpand(categoria.id()).toUri();

		return ResponseEntity.created(url).body(categoria);
	}

	@PutMapping("/{categoriaId}")
	@Transactional
	public ResponseEntity<DatosResumidosCategoria> editarCategoria(
			@PathVariable 
			Long categoriaId,

			@RequestBody
			@Valid
			DatosGuardarCategoria datosCategoria) {

		DatosResumidosCategoria categoria = etiquetaServicio.editarCategoria(categoriaId, datosCategoria);

		return ResponseEntity.ok(categoria);
	}

	@DeleteMapping("/{categoriaId}")
	@Transactional
	public ResponseEntity<Void> eliminarCategoria(@PathVariable Long categoriaId) {
		etiquetaServicio.eliminarCategoria(categoriaId);
		return ResponseEntity.noContent().build();
	}
}