package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class TrainerAlreadyExistException extends ResponseException{

    public TrainerAlreadyExistException(){
        super("Este entrenador ya existe, escoger uno nuevo");
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.name = TrainerAlreadyExistException.class.getName();
        this.description = "Se intento crear un nuevo entrenador con un nombre ya existente, este debe ser unico";
    }
}
