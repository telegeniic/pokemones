package com.demon.slayer.pokemonapi.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUsuario {
    
    private String usuario;
	private int rol;
    private String password;

    public String getUsuario(){
        return usuario;
    }
    public int getRol(){
        return rol;
    }
    public String getPassword(){
        return password;
    }
}



