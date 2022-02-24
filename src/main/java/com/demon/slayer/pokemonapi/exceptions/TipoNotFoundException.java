package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

public class TipoNotFoundException extends ResponseException{

    public TipoNotFoundException(){
        super("El tipo no se encontro, favor de mandar el correcto");
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.name = TeamNameAlreadyExistException.class.getName();
        this.description = "Se buscar un tipo que no existe en la BD";
    }
}
