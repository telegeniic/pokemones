package com.demon.slayer.pokemonapi.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdateUsuario {
	
	private RequestUsuario usuario;
	
	private RequestEquipo equipo;
	@JsonProperty("pokemons")
	private List<RequestPokemon> pokemonList;

}
