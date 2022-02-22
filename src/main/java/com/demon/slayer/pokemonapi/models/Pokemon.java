package com.demon.slayer.pokemonapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demon.slayer.pokemonapi.request.RequestPokemon;

import lombok.Data;

@Data
@Entity
@Table(name ="pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idpokemon;
	
	@Column(name="nombre")
	private String nombre;
	
	public Pokemon(RequestPokemon p) {
		this.nombre = p.getNombre();
	}

}
