package com.diego.morpheustest.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	File data = new File("C:\\Users\\diego\\Development\\ws-morpheustest2\\morpheustest2\\backend\\src\\main\\resources\\data.sql");
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> FindAll() {
		List<Usuario> list = repository.findAllByOrderByCodigoAsc();
		return list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public UsuarioDTO insert(String nome) {
		Usuario usuario = new Usuario(null, nome);
		
		try {
			FileWriter writer = new FileWriter(data);
			writer.write("INSERT INTO usuarios (nome) VALUES ('" + nome + "');");
			writer.close();
			System.out.println("Cadastro realizado.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		
		usuario = repository.save(usuario);
		
		return new UsuarioDTO(usuario);
	}
	
}
