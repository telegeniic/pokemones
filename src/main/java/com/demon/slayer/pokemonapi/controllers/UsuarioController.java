package com.demon.slayer.pokemonapi.controllers;

import javax.validation.Valid;

import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.request.RequestEquipo;
import com.demon.slayer.pokemonapi.request.RequestRegister;
import com.demon.slayer.pokemonapi.request.RequestTipo;
import com.demon.slayer.pokemonapi.response.ResponsePokemon;
import com.demon.slayer.pokemonapi.services.EquipoService;
import com.demon.slayer.pokemonapi.services.PokemonService;
import com.demon.slayer.pokemonapi.services.TipoService;
import com.demon.slayer.pokemonapi.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
	UsuarioService usuarioService;
    @Autowired
   PokemonService pokemonService;
    @Autowired
    TipoService tipoService;
    
    @Autowired
   EquipoService equipoService;
     
    
    @PostMapping("/register")
    public String createUsuario(@Valid @RequestBody RequestRegister datos){
        return usuarioService.createUsuario(datos);

    }

    
    
    @PostMapping("/equipo")
    public String guardarEquipo(@Valid @RequestBody RequestEquipo equipo) {
    	return equipoService.createEquipo(equipo);
    	
    }
    
    @GetMapping("/tipo")
    public Tipo getTipo(@Valid @RequestBody RequestTipo tipo) {
    	return tipoService.findTipoByNombre(tipo);
    	
    }
    
   
	 
	@GetMapping("getByPokemon/{nombre}")
	public ResponsePokemon getByName(@PathVariable String nombre){
		return pokemonService.buscarPokemon(nombre);

	}
	

    
}

