package com.demon.slayer.pokemonapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RequestEquipo {
	
	private String entrenador;
	@JsonProperty("nombre_equipo")
	private String nombreEquipo;

}
