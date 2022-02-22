package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class TeamNameAlreadyExistException extends ResponseException{

    public TeamNameAlreadyExistException(){
        super("Este nombre de equipo ya existe, escoger uno nuevo");
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.name = TeamNameAlreadyExistException.class.getName();
        this.description = "Se intento introducir un equipo con un nombre ya existente";
    }
}
