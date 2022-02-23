package com.demon.slayer.pokemonapi.controllers;

import javax.validation.Valid;

import com.demon.slayer.pokemonapi.models.Testing;
import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.request.RequestEquipo;
import com.demon.slayer.pokemonapi.request.RequestLoginUsuario;
import com.demon.slayer.pokemonapi.request.RequestRegister;
import com.demon.slayer.pokemonapi.request.RequestTipo;
import com.demon.slayer.pokemonapi.response.JWTAuthResponse;
import com.demon.slayer.pokemonapi.response.ResponsePokemon;
import com.demon.slayer.pokemonapi.security.JwtTokenProvider;
import com.demon.slayer.pokemonapi.services.EquipoService;
import com.demon.slayer.pokemonapi.services.PokemonService;
import com.demon.slayer.pokemonapi.services.TipoService;
import com.demon.slayer.pokemonapi.services.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
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
   @Autowired
    private AuthenticationManager authenticationManager;

   @Autowired
    private JwtTokenProvider tokenProvider;

    Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
     
    
    @PostMapping("/register")
    public String createUsuario(@Valid @RequestBody RequestRegister datos){
        return usuarioService.createUsuario(datos);

    }

    @PostMapping("/login")
    public JWTAuthResponse login(@RequestBody RequestLoginUsuario usuario){
        logger.warn("Se hizo la llamada");
        logger.warn("username: "+usuario.getUsuario());
        logger.warn("password: "+usuario.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            usuario.getUsuario(), usuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.generateToken(authentication);
        return new JWTAuthResponse(token);
    }

    
    
    @PostMapping("/equipo")
    public String guardarEquipo(@Valid @RequestBody RequestEquipo equipo) {
    	return equipoService.createEquipo(equipo);
    	
    }
    
    @GetMapping("/tipo")
    public Tipo getTipo(@Valid @RequestBody RequestTipo tipo) {
    	return tipoService.findTipoByNombre(tipo.getNombreTipo());
    	
    }
    
   
	 
	@GetMapping("getByPokemon/{nombre}")
	public ResponsePokemon getByName(@PathVariable String nombre){
		return pokemonService.buscarPokemon(nombre);

	}

    @PostMapping("testing")
    public String testing(@RequestBody Testing testing){
        return "funciono";
    }
	

    
}

