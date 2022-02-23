package com.demon.slayer.pokemonapi.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name ="equipos")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idequipo;
	
	@Column(name="entrenador")
	private String entrenador; 
	
	@Column(name="nombreEquipo")
	private String nombreequipo;
	
	@OneToOne(mappedBy = "equipo")
	private Usuario usuario;
	
	
	
	@ManyToMany(mappedBy="equipos")
	private List<Pokemon> pokemons =new ArrayList<>();
	


	public void setNombreEquipo(String nombre_equipo) {
		this.nombreequipo=nombre_equipo;
		
	}

	public void setEntrenador(String entrena) {
		this.entrenador=entrena;
		
	}

	public void setPokemons(List<Pokemon> list) {
		this.pokemons=list;
	}

	public String getNombreequipo() {
		return nombreequipo;
	}

    public List<Pokemon> getPokemons() {
        return pokemons;
    }


}
