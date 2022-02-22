package com.demon.slayer.pokemonapi.services;

import com.demon.slayer.pokemonapi.models.Equipo;
import com.demon.slayer.pokemonapi.models.Pokemon;
import com.demon.slayer.pokemonapi.models.Usuario;
import com.demon.slayer.pokemonapi.repositories.EquipoRepository;
import com.demon.slayer.pokemonapi.repositories.PokemonRepository;
import com.demon.slayer.pokemonapi.repositories.UsuarioRepository;
import com.demon.slayer.pokemonapi.request.RequestUpdateUsuario;
import com.demon.slayer.pokemonapi.request.RequestUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    PokemonRepository pokemonRepository;

    public String createUsuario(RequestUsuario datos){
            usuarioRepository.save(new Usuario(datos));
            return "Todo salio bien";
    }
    //se deben guardar los cambios al usuario
    public String requestUpdateUsuario(RequestUpdateUsuario datos) {
    	 	Usuario usuario = usuarioRepository.findbyUsuario(datos.getUsuario().getUsuario()).get();
    		usuarioRepository.save(new Usuario(datos.getUsuario()));
    		equipoRepository.save(new Equipo(datos.getEquipo()));
    		
    		datos.getPokemonList().forEach(p -> pokemonRepository.save(new Pokemon(p)));
    		return "Usuario actualizado exitosamente";
    }
}
