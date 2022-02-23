package com.demon.slayer.pokemonapi.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTipo {
	private String nombreTipo;

	public String getNombreTipo() {
		return nombreTipo;
	}

}
