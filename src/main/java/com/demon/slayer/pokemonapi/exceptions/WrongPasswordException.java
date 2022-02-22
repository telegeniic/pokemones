package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class WrongPasswordException extends ResponseException{

    public WrongPasswordException(){
        super("Este Usuario no tiene permisos, favor de iniciar sesion");
        this.status = HttpStatus.UNAUTHORIZED;
        this.name = WrongPasswordException.class.getName();
        this.description = "Se introdujo una contraseña que no es la del usuario";
    }
}
