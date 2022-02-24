package com.demon.slayer.pokemonapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestEquipo {
	
	private String entrenador;
	@JsonProperty("nombre_equipo")
	private String nombreEquipo;
  
	public String getEntrenador() {
		return entrenador;
	}
    public String getNombre_equipo() {
        return nombreEquipo;
    }
    public String getNombreequipo() {
        return null;
    }

}
