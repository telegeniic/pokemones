package com.demon.slayer.pokemonapi.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPokemon {
	
	private String nombre;
	private List<String> tipos;

}
