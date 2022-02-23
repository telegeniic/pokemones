package com.demon.slayer.pokemonapi.services;

import com.demon.slayer.pokemonapi.models.Usuario;
import com.demon.slayer.pokemonapi.repositories.UsuarioRepository;
import com.demon.slayer.pokemonapi.request.RequestPokemon;
import com.demon.slayer.pokemonapi.request.RequestRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
		@Autowired
		UsuarioRepository usuarioRepository;
		@Autowired
		PokemonService pokemonService;
		@Autowired
		EquipoService equipoService;

		@Autowired
		private PasswordEncoder passwordEncoder;
	 

	    public String createUsuario(RequestRegister registro){
	    	if(this.findByUsuario(registro.getUsuario().getUsuario())==null) {
	 			for (RequestPokemon pokemon:registro.getPokemons()) {
		 			pokemonService.createPokemon(pokemon, registro.getEquipo());
	 			}
				Usuario user = new Usuario();
				user.setUsuario(registro.getUsuario().getUsuario());
				user.setRol(registro.getUsuario().getRol());
				user.setPassword(passwordEncoder.encode(registro.getUsuario().getPassword()));
				user.setEquipo(equipoService.obtenerEquipo(registro.getEquipo().getNombre_equipo(),registro.getEquipo().getEntrenador()));
	            usuarioRepository.save(user);
	            return "Bien";
	    	}
	    	else
	    		return "Un error";
	    		
	         
	    }
	    public Usuario findByUsuario(String user) {
	    	return usuarioRepository.findByUsuario(user).orElse(null);
	    }
	    
	    
}
