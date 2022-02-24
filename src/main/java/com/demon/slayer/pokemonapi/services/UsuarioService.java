package com.demon.slayer.pokemonapi.services;

import java.util.ArrayList;
import java.util.List;

import com.demon.slayer.pokemonapi.models.Equipo;
import com.demon.slayer.pokemonapi.models.Pokemon;
import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.models.Usuario;
import com.demon.slayer.pokemonapi.repositories.EquipoRepository;
import com.demon.slayer.pokemonapi.repositories.PokemonRepository;
import com.demon.slayer.pokemonapi.repositories.UsuarioRepository;
import com.demon.slayer.pokemonapi.request.RequestPokemon;
import com.demon.slayer.pokemonapi.request.RequestRegister;
import com.demon.slayer.pokemonapi.request.RequestUpdateUsuario;
import com.demon.slayer.pokemonapi.request.RequestUsuario;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	TipoService tipoService;
	@Autowired
	TipoRepository tipoRepository;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PasswordEncoder passwordEncoder;
	

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
			user.setPassword(passwordEncoder.encode(registro.getUsuario().getPassword()));
			user.setEquipo(equipoService.obtenerEquipo(registro.getEquipo()));
			usuarioRepository.save(user);
			return "Bien";
		}
		else
			return "Un error";
			
			
	}
	public Usuario findByUsuario(String user) {
		return usuarioRepository.findByUsuario(user).orElse(null);
	}
	    
	    
    //se deben guardar los cambios al usuario
    public String requestUpdateUsuario(RequestUpdateUsuario datos, String username) {
		logger.info("Se llamo la funcion Request update");
		logger.info("Datos: "+datos);
		logger.info("Username: "+username);
		Usuario usuario = usuarioRepository.findByUsuario(username).orElse(null);
		logger.info("usuario: "+usuario);
		List<Pokemon> pokemons = new ArrayList<>();
		usuario.setRol(datos.getUser().getRol());
		usuario.getEquipo().setEntrenador(datos.getEquipo().getEntrenador());
		usuario.getEquipo().setNombreEquipo(datos.getEquipo().getNombreEquipo());
		datos.getPokemonList().forEach(p -> {
			List<Tipo> tipos = new ArrayList<>();
			p.getTipos().forEach((t) -> {
				logger.info("buscando tipo: "+t);
				tipos.add(tipoService.findTipoByNombre(t));
			});
			Pokemon pokemon = new Pokemon();
			pokemon.setTipos(tipos);
			pokemon.setNombre(p.getName());
			pokemons.add(pokemon);
		});
		return "Usuario actualizado exitosamente";
    }

	public PokemonsResponse pokemonesUsuario(String name) {
		Usuario user =(usuarioRepository.findByUsuario(name).orElse(null));
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
	  
	 
	    
	    
	    
	    
}
