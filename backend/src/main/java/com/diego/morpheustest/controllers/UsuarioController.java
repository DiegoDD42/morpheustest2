package com.diego.morpheustest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.diego.morpheustest.dto.UsuarioDTO;
import com.diego.morpheustest.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	public UsuarioService service;
	
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> list = service.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
}
