package com.demon.slayer.pokemonapi.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RequestPokemon {
	@JsonProperty("nombre")
	private String name;
	private List<String> tipos;

}
