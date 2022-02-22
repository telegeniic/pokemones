package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UserNotFoundException extends ResponseException{

    public UserNotFoundException(){
        super("Usuario no encontrado");
        this.status = HttpStatus.NOT_FOUND;
        this.name = UserNotFoundException.class.getName();
        this.description = "Se busco un nombre de usuario, pero este no existe";
    }
}
