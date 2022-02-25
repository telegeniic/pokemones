package com.demon.slayer.pokemonapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ResponseException extends RuntimeException{
    protected HttpStatus status;
    protected String description;
    protected String name;
    
    public ResponseException(String message){
        super(message);
    }

    public ResponseException(String message, String description, String name, HttpStatus status){
        super(message);
        this.description = description;
        this.name = name;
        this.status = status;
    }
}
