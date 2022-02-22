package com.demon.slayer.pokemonapi.services;

import com.demon.slayer.pokemonapi.models.Usuario;
import com.demon.slayer.pokemonapi.repositories.UsuarioRepository;
import com.demon.slayer.pokemonapi.request.RequestUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	  @Autowired
	    UsuarioRepository usuarioRepository;

	    public String createUsuario(RequestUsuario datos){
	    	if(this.findByUsuario(datos.getUsuario())==null) {
	 
	             usuarioRepository.save(new Usuario(datos));
	             return "Bien";
	    	}
	    	else
	    		return "Un error";
	    		
	         
	    }
	    public Usuario findByUsuario(String user) {
	    	return usuarioRepository.findByUsuario(user);
	    }
}
