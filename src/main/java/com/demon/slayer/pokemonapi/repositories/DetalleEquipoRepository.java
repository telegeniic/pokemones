package com.demon.slayer.pokemonapi.repositories;

import com.demon.slayer.pokemonapi.models.DetalleEquipos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleEquipoRepository extends JpaRepository<DetalleEquipos, String>  {
    
}
