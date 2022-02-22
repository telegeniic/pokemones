package com.demon.slayer.pokemonapi.services;

import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.repositories.TipoRepository;
import com.demon.slayer.pokemonapi.request.RequestTipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TipoService {
	
	 @Autowired 
	  TipoRepository tipoRepository;
	 
	 public Tipo findTipoByNombre(RequestTipo tipo) {
	    	return tipoRepository.findByTipo(tipo.getNombreTipo());


	    }

}
