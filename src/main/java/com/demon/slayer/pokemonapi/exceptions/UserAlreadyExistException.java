package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UserAlreadyExistException extends ResponseException{

    public UserAlreadyExistException(){
        super("Este Usuario ya existe, escoger uno nuevo");
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.name = UserAlreadyExistException.class.getName();
        this.description = "Se intento crear un nuevo usuario con un nombre ya existente, este debe ser unico";
    }
}
