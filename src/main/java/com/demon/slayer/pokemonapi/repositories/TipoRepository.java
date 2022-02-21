package com.demon.slayer.pokemonapi.repositories;

import com.demon.slayer.pokemonapi.models.Tipo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, String>  {
    
}
