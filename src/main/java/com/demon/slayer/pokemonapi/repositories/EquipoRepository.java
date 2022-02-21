package com.demon.slayer.pokemonapi.repositories;

import com.demon.slayer.pokemonapi.models.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, String> {
    
}
