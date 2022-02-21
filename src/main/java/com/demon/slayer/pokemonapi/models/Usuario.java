package com.demon.slayer.pokemonapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demon.slayer.pokemonapi.request.RequestUsuario;

import lombok.Data;

@Data
@Entity
@Table(name="Usuarios")

public class Usuario {
	
	@Id
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="rol")
	private int rol;
	
	@Column(name="pass")
	private String password;

	public Usuario(RequestUsuario datos){
		this.usuario=datos.getUsuario();
		this.rol=datos.getRol();
		this.password=datos.getPassword();
	}

}
