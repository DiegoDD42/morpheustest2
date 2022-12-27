package com.diego.morpheustest.dto;

import java.io.Serializable;

import com.diego.morpheustest.entities.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public UsuarioDTO(Usuario entity) {
		codigo = entity.getCodigo();
		nome = entity.getNome();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
