package com.demon.slayer.pokemonapi.response;

import java.util.List;

public class PokemonsResponse {
	private List<ResponsePokemon> listaPokemons;

	public List<ResponsePokemon> getListaPokemons() {
		return listaPokemons;
	}

	public void setListaPokemons(List<ResponsePokemon> listaPokemons) {
		this.listaPokemons = listaPokemons;
	}

}
