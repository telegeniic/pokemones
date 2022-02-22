package com.demon.slayer.pokemonapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demon.slayer.pokemonapi.models.*;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Usuario findByUsuario(String user);
	    
	}


