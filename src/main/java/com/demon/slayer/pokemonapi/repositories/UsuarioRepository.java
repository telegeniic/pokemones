package com.demon.slayer.pokemonapi.repositories;

import com.demon.slayer.pokemonapi.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
}
