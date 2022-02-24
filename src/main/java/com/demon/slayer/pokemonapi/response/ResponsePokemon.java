package com.demon.slayer.pokemonapi.response;

import java.util.List;


public class ResponsePokemon {
	

	
	private long id;
	private String nombre;
	private List<String> tipos;

	public void setNombre(String nombre2) {
		this.nombre=nombre2;
		
	}

	public String getNombre() {
		return nombre;
	}

	public List<String> getTipos() {
		return tipos;
	}

	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(long idpokemon) {
		this.id = idpokemon;
		
	}

}
