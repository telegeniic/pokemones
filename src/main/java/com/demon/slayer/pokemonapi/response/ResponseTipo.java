package com.demon.slayer.pokemonapi.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTipo {
	private String nombreTipo;

	public void setNombreTipo(String nombretipo2) {
		this.nombreTipo=nombretipo2;
		
	}
	public String getNombreTipo(){
		return this.nombreTipo;
	}
}
