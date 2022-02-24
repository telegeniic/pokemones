package com.demon.slayer.pokemonapi.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ResponseTipos {
	List<String> tipos= new ArrayList<String>();

	public void setTipos(List<String> respuestaTipo) {
		this.tipos=respuestaTipo;
	}

    public List<String> getTipos() {
        return tipos;
    }

}
