package com.demon.slayer.pokemonapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Usuarios")

public class Usuario {
	
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="rol")
	private int rol;
	
	@Column(name="pass")
	private String password;

}
