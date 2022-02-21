package com.demon.slayer.pokemonapi.repositories;

import com.demon.slayer.pokemonapi.models.DetalleTipos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleTipoRespository extends JpaRepository<DetalleTipos, String> {
    
}
