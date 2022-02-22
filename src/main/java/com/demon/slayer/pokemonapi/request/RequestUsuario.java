package com.demon.slayer.pokemonapi.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUsuario {
    
    private String usuario;
	private String rol;
    private String password;

    public String getUsuario(){
        return usuario;
    }
    public String getRol(){
        return rol;
    }
    public String getPassword(){
        return password;
    }
}



