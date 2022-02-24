package com.demon.slayer.pokemonapi.repositories;

import java.util.Optional;

import com.demon.slayer.pokemonapi.models.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
	
	@Query("From Pokemon where nombre=:nombre")
	Optional<Pokemon> findByNombre(@Param("nombre") String nombre);

}
