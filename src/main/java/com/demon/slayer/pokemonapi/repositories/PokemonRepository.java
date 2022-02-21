package com.demon.slayer.pokemonapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Usuario, String> {
    
}
