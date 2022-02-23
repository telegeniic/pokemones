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
			user.setEquipo(equipoService.obtenerEquipo(registro.getEquipo().getNombreEquipo(),registro.getEquipo().getEntrenador()));
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
    	 	Usuario usuario = usuarioRepository.findByUsuario(username).get();
			List<Pokemon> pokemons = new ArrayList<>();
			usuario.setRol(datos.getUsuario().getRol());
			usuario.getEquipo().setEntrenador(datos.getEquipo().getEntrenador());
			usuario.getEquipo().setNombreEquipo(datos.getEquipo().getNombreEquipo());
    		datos.getPokemonList().forEach(p -> {
				List<Tipo> tipos = new ArrayList<>();
				p.getTipos().forEach((t) -> {
					tipos.add(tipoService.findTipoByNombre(t));
				});
				Pokemon pokemon = new Pokemon();
				pokemon.setTipos(tipos);
				pokemon.setNombre(p.getName());
				pokemons.add(pokemon);
			});
    		return "Usuario actualizado exitosamente";
    }
}