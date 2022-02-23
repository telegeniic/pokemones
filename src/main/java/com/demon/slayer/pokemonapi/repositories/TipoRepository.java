package com.demon.slayer.pokemonapi.repositories;

import java.util.Optional;

import com.demon.slayer.pokemonapi.models.Tipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface TipoRepository extends JpaRepository<Tipo, Long>{
	

		
	@Query("From Tipo where nombretipo=:nombretipo ")
	Optional<Tipo> findByTipo(@Param("nombretipo") String nombretipo);

}
