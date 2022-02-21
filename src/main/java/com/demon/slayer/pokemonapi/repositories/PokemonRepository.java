package com.demon.slayer.pokemonapi.repositories;

import com.demon.slayer.pokemonapi.models.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, String> {
    
}
