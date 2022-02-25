package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class SamePokemonException extends ResponseException{

    public SamePokemonException(){
        super("Pokemones con nombres repetidos");
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.name = UserAlreadyExistException.class.getName();
        this.description = "Se intentó agregar dos pokemones con el mismo nombre a un equipo";
    }
}
