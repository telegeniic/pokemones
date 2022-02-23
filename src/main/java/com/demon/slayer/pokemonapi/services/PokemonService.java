package com.demon.slayer.pokemonapi.services;

import java.util.ArrayList;
import java.util.List;

import com.demon.slayer.pokemonapi.models.Equipo;
import com.demon.slayer.pokemonapi.models.Pokemon;
import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.repositories.PokemonRepository;
import com.demon.slayer.pokemonapi.request.RequestEquipo;
import com.demon.slayer.pokemonapi.request.RequestPokemon;
import com.demon.slayer.pokemonapi.request.RequestTipo;
import com.demon.slayer.pokemonapi.response.ResponsePokemon;
import com.demon.slayer.pokemonapi.response.ResponseTipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PokemonService {
	@Autowired 
	PokemonRepository pokemonRepository;
   @Autowired
   TipoService tipoService;
  
   @Autowired
   EquipoService equipoService;
   
   public String createPokemon(RequestPokemon req,RequestEquipo reqE) {
	   Pokemon pokemon = new Pokemon();
	   pokemon.setNombre(req.getName());
	   pokemon.setStatus(1);
	   try {
	   List<Tipo> tipos = new ArrayList();
	   for (String tipo:req.getTipos()) {
		   Tipo type = tipoService.findTipoByNombre(tipo);
		   tipos.add(type);
	   }
	   
	  equipoService.createEquipo(reqE);
	  Equipo eq= equipoService.obtenerEquipo(reqE.getNombre_equipo(),reqE.getEntrenador());
	  List<Equipo> equipos = new ArrayList();
	  equipos.add(eq);
	   pokemon.setTipos(tipos);
	   pokemon.setEquipos(equipos);
	  
	   pokemonRepository.save(pokemon);
	   return "Pokemon Guardado";
	   }catch(Exception e) {
		   
		   return "Algo salió mal"+e.getMessage();
	   }
		   
   }
   public ResponsePokemon buscarPokemon(String name) {
	   ResponsePokemon resp=new ResponsePokemon();
	   Pokemon pok =pokemonRepository.findByNombre(name);
	   resp.setNombre(pok.getNombre());
	   String rT;
	   List <String> list= new ArrayList();
	   for (Tipo resT:pok.getTipos()) {
		   rT=resT.getNombretipo();
		   list.add(rT);
	   }
	   resp.setTipos(list);
	   return resp;
	   
   }
   
   public Pokemon obtenerPokemon(String name) {
	   
	   
	   return pokemonRepository.findByNombre(name);
	   
   }


}

