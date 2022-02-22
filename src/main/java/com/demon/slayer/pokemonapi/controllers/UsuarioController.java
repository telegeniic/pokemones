package com.demon.slayer.pokemonapi.controllers;

import javax.validation.Valid;

import com.demon.slayer.pokemonapi.request.RequestUsuario;
import com.demon.slayer.pokemonapi.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class UsuarioController {
    
    @Autowired
	UsuarioService usuarioService;
     
    
    @PostMapping("/createUsuario")
    public String createUsuario(@Valid @RequestBody RequestUsuario datos){
        return usuarioService.createUsuario(datos);

    }
}
