package com.demon.slayer.pokemonapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name ="pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idpokemon;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name="pokemon_tipo",
				joinColumns=@JoinColumn(name="idpokemon"),
				inverseJoinColumns= @JoinColumn(name="idTipo")
	)
	private List<Tipo> tipos =new ArrayList<>();
	

	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name="pokemon_equipo",
				joinColumns=@JoinColumn(name="idpokemon"),
				inverseJoinColumns= @JoinColumn(name="idequipo")
	)
	private List<Equipo> equipos =new ArrayList<>();
	
	

	
}