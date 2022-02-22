package com.demon.slayer.pokemonapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestEquipo {
	
	private String entrenador;
	@JsonProperty("nombre_equipo")
	private String nombreEquipo;

}
