package com.demon.slayer.pokemonapi.services;

import java.util.ArrayList;
import java.util.List;

import com.demon.slayer.pokemonapi.models.Tipo;
import com.demon.slayer.pokemonapi.repositories.TipoRepository;
import com.demon.slayer.pokemonapi.request.RequestTipo;
import com.demon.slayer.pokemonapi.response.ResponseTipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TipoService {
	
	 @Autowired 
	  TipoRepository tipoRepository;
	 
	 public Tipo findTipoByNombre(RequestTipo tipo) {
	    	return tipoRepository.findByTipo(tipo.getNombreTipo());


	    }

		public  void agregarTipos() {
			String [] tiposDefinidos = {"Normal", "Fire", "Water","Grass","Flying", "Fighting", "Poison", "Electric",
										 "Ground", "Rock", "Psychic", "Ice", "Bug", "Ghost", "Steel", "Dragon", "Dark", "Fairy"};
			List<Tipo> tipo = new ArrayList<Tipo>();
			
			for(String tipito:tiposDefinidos) {
				Tipo type =new Tipo();
				type.setNombretipo(tipito);
				tipo.add(type);
			}
			for (Tipo mostrar:tipo) {
				System.out.println(mostrar.getNombretipo());
			}
			tipoRepository.saveAll(tipo);
			
		}
		public ResponseTipos getAllTipos() {
		   
			   List<Tipo> type= tipoRepository.findAll();
			   if (type.isEmpty()) {
				   this.agregarTipos();
			   }
			   ResponseTipos rt=new ResponseTipos();
			   List<String> respuestaTipo=new ArrayList();
			   for(Tipo t: type) {
				   
				   respuestaTipo.add(t.getNombretipo());
			   }
			   rt.setTipos(respuestaTipo);
				
			   return rt;
		   }

}
