package com.diego.morpheustest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.morpheustest.dto.UsuarioDTO;
import com.diego.morpheustest.entities.Usuario;
import com.diego.morpheustest.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> FindAll() {
		List<Usuario> list = repository.findAllByOrderByCodigoAsc();
		return list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
}
