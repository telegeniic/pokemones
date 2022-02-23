package com.demon.slayer.pokemonapi.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPokemon {
	private String name;
	private List<RequestTipo> tipos;
	
	
	
	public String getName() {
		return name;
	}
	
	

	public List<RequestTipo> getTipos() {
		return tipos;
	}

}
