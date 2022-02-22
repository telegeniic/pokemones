package com.demon.slayer.pokemonapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idpokemon;
	
	@Column(name="nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name="id_equipo")
	private DetalleEquipos detEquipo;

	@OneToMany(mappedBy="pokemon")
	private List<DetalleEquipos> detalleEquipo = new ArrayList<>();
	
	@OneToMany(mappedBy="Tipopokemon")
	private List<DetalleTipos> detalleTipos = new ArrayList<>();
	
}
