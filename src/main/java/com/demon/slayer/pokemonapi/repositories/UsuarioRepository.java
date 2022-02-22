package com.demon.slayer.pokemonapi.repositories;

import com.demon.slayer.pokemonapi.models.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Optional<Usuario> findbyUsuario(String usuario);
    
}
