package com.demon.slayer.pokemonapi.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLoginUsuario {

    private String usuario;

    private String password;
    
}
