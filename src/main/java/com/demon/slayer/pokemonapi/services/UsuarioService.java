package com.demon.slayer.pokemonapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demon.slayer.pokemonapi.models.Pokemon;
import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.models.Usuario;
import com.demon.slayer.pokemonapi.repositories.TipoRepository;
import com.demon.slayer.pokemonapi.repositories.UsuarioRepository;
import com.demon.slayer.pokemonapi.request.RequestPokemon;
import com.demon.slayer.pokemonapi.request.RequestRegister;
import com.demon.slayer.pokemonapi.response.PokemonsResponse;
import com.demon.slayer.pokemonapi.response.ResponsePokemon;

import org.springframework.beans.factory.annotation.Autowired;
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
		 TipoRepository tipoRepository;
	  @Autowired
		 TipoService tipoService;
	  
	 

	    public String createUsuario(RequestRegister registro){
	    	List<Tipo> type= tipoRepository.findAll();
			if (type.isEmpty()) {
				tipoService.agregarTipos();
			}
	    	if(this.findByUsuario(registro.getUsuario().getUsuario())==null) {
	 for (RequestPokemon pokemon:registro.getPokemons()) {
		 pokemonService.createPokemon(pokemon, registro.getEquipo());
	 }
	 Usuario user = new Usuario();
	 user.setUsuario(registro.getUsuario().getUsuario());
	 user.setRol(registro.getUsuario().getRol());
	 user.setPassword(registro.getUsuario().getPassword());
	 user.setEquipo(equipoService.obtenerEquipo(registro.getEquipo().getNombre_equipo(),registro.getEquipo().getEntrenador()));
	             usuarioRepository.save(user);
	             return "Bien";
	    	}
	    	else
	    		return "Un error";
	    		
	         
	    }
	    public Optional<Usuario> findByUsuario(String user) {
	    	return usuarioRepository.findByUsuario(user);
	    }
	    
	    
	    public PokemonsResponse pokemonesUsuario(String name) {
	    	Usuario user =(usuarioRepository.findByUsuario(name)).get();
	    	PokemonsResponse regresar=new PokemonsResponse();
	    	List<ResponsePokemon> pokemones =new ArrayList();
	    	for(Pokemon pokemon:user.getEquipo().getPokemons()) {
	    		ResponsePokemon respuesta =new ResponsePokemon();
	    		respuesta.setNombre(pokemon.getNombre());
	    		List<String> types=new ArrayList();
	    		for(Tipo type:pokemon.getTipos()) {
	    			types.add(type.getNombretipo());
	    		}
	    		respuesta.setTipos(types);
	    		pokemones.add(respuesta);
	    	}
	    	regresar.setListaPokemons(pokemones);
	    	return regresar;
	    }
	    
}
