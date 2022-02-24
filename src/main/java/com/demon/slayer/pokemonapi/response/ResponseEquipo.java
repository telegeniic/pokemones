package com.demon.slayer.pokemonapi.response;

import com.demon.slayer.pokemonapi.models.Equipo;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEquipo {

    private String entrenador;

    @JsonProperty("nombre_equipo")
    private String nombreEquipo;

    public ResponseEquipo(Equipo equipo) {
        this.entrenador = equipo.getEntrenador();
        this.nombreEquipo = equipo.getNombreequipo();
    }

}
