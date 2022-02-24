package com.demon.slayer.pokemonapi.services;

import java.util.ArrayList;
import java.util.List;

import com.demon.slayer.pokemonapi.models.Equipo;
import com.demon.slayer.pokemonapi.models.Pokemon;
import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.repositories.PokemonRepository;
import com.demon.slayer.pokemonapi.repositories.TipoRepository;
import com.demon.slayer.pokemonapi.request.RequestEquipo;
import com.demon.slayer.pokemonapi.request.RequestPokemon;
import com.demon.slayer.pokemonapi.response.ResponsePokemon;
import com.demon.slayer.pokemonapi.response.ResponseTipo;
import com.demon.slayer.pokemonapi.response.ResponseTipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PokemonService {
	
	@Autowired 
	PokemonRepository pokemonRepository;
	@Autowired 
	TipoRepository tipoRepository;
   @Autowired
   TipoService tipoService;
  
   @Autowired
   EquipoService equipoService;
   
   public Pokemon createPokemon(RequestPokemon req,RequestEquipo reqE) {
		Pokemon pokemon = new Pokemon();
		pokemon.setNombre(req.getName());
		pokemon.setStatus(1);
		try {
		List<Tipo> tipos = new ArrayList();
		for (String tipo:req.getTipos()) {
			Tipo type = tipoService.findTipoByNombre(tipo);
			tipos.add(type);
		}
		
		Equipo eq= equipoService.obtenerEquipo(reqE);
		List<Equipo> equipos = new ArrayList();
		equipos.add(eq);
		pokemon.setTipos(tipos);
		pokemon.setEquipos(equipos);
		return pokemonRepository.save(pokemon);
		}catch(Exception e) {
			
			return null;
		}
		   
   }
   public ResponsePokemon buscarPokemon(String name) {
	   ResponsePokemon resp=new ResponsePokemon();
	   Pokemon pok =pokemonRepository.findByNombre(name).orElse(null);
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
		return pokemonRepository.findByNombre(name).orElse(null);
	
	}

	public List<Pokemon> pokemonEquipo(Equipo e){
		List<Pokemon> listaPokemons=pokemonRepository.findAll();
		List<Pokemon> pokemonesEquipo=new ArrayList<>();
		for(Pokemon pokemon:listaPokemons) {
			if(pokemon.getEquipos().contains(e)) {
		pokemonesEquipo.add(pokemon);
			}
		}
		
		return pokemonesEquipo;
	}
	public List<Tipo> tipoPkemono(Pokemon p){
		List<Tipo> listaTipo=tipoRepository.findAll();
		List<Tipo> tiposPokemon=new ArrayList<>();
		for(Tipo tipo:listaTipo) {
			if(tipo.getPokemons().contains(p)) {
		tiposPokemon.add(tipo);
			}
		}
		
		return tiposPokemon;
	}

	public ResponseTipos tipos(Pokemon p) {
		List<String> nombreTipos=new ArrayList<>();
		ResponseTipos respuesta=new ResponseTipos();
		List<Tipo> types =this.tipoPkemono(p);
		for(Tipo tipo:types)
			nombreTipos.add(tipo.getNombretipo());
		respuesta.setTipos(nombreTipos);
		return respuesta;
	}



}

