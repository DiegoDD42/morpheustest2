package com.diego.morpheustest.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.morpheustest.dto.UsuarioDTO;
import com.diego.morpheustest.entities.Usuario;

@Service
public class UsuarioService {
	
	File data = new File("C:\\Users\\diego\\Development\\ws-morpheustest2\\morpheustest2\\backend\\src\\main\\resources\\data.txt");
	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> FindAll() {
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		try {
			Scanner reader = new Scanner(data);
			while (reader.hasNextLine()) {
				String nome = reader.nextLine();
				Usuario usuario = new Usuario(null, nome);
				listUsuario.add(usuario);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return listUsuario.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
}
