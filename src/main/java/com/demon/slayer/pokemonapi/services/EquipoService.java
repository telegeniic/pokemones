package com.demon.slayer.pokemonapi.services;

import com.demon.slayer.pokemonapi.models.Equipo;
import com.demon.slayer.pokemonapi.repositories.EquipoRepository;
import com.demon.slayer.pokemonapi.request.RequestEquipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EquipoService {
	@Autowired
	 EquipoRepository equipoRepository;
	
	public String createEquipo (RequestEquipo req) {
		 Equipo equipo =new Equipo();
		 equipo.setNombreEquipo(req.getNombreEquipo());
		 equipo.setEntrenador(req.getEntrenador());
		equipoRepository.save(equipo);
		 return "Equipo Agregado";
		 
	}
	
 public Equipo obtenerEquipo(String nombre,String entrenador) {
		 
		 return equipoRepository.findByNombre(nombre, entrenador);
		 
	 }
}
