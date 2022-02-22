package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UnauthorizedUserException extends ResponseException{

    public UnauthorizedUserException(){
        super("Este Usuario no tiene permisos, favor de iniciar sesion");
        this.status = HttpStatus.UNAUTHORIZED;
        this.name = UnauthorizedUserException.class.getName();
        this.description = "Se intento realizar alguna operacion sin autorizacion previa o con token vencido";
    }
}
