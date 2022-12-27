package com.diego.morpheustest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diego.morpheustest.dto.UsuarioDTO;
import com.diego.morpheustest.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	public UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> list = service.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> insert(@RequestBody String nome) {
		UsuarioDTO usuario = service.insert(nome);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(usuario.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	
}
