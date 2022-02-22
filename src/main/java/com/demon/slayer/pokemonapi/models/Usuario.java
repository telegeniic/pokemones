package com.demon.slayer.pokemonapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.demon.slayer.pokemonapi.request.RequestUsuario;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="Usuarios")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
	
	@Id
	@Column(name="usuario",unique=true)
	private String usuario;
	
	@Column(name="rol")
	private String rol;
	
	@Column(name="pass")
	private String password;

	/*
	@OneToOne
	@JoinColumn(name = "team_id")
	private Equipo equipo;
	*/


	public Usuario(RequestUsuario datos){
		this.usuario=datos.getUsuario();
		this.rol=datos.getRol();
		this.password=datos.getPassword();

	}

	
}
