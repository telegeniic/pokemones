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
            usuarioRepository.save(new Usuario(datos));
            return "Todo salio bien";
    }
}
