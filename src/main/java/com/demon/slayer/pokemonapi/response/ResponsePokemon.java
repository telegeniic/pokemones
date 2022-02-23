package com.demon.slayer.pokemonapi.response;

import java.util.List;



public class ResponsePokemon {
	
	private String nombre;
	private List<ResponseTipo>tipos;

	public void setNombre(String nombre2) {
		this.nombre=nombre2;
		
	}

	public String getNombre() {
		return nombre;
	}

	public List<ResponseTipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<ResponseTipo> tipos) {
		this.tipos = tipos;
	}
	
	

}
