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

import org.hibernate.type.ListType;

import lombok.Data;

@Data
@Entity
@Table(name ="detalleequipos")
public class DetalleEquipos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="idpokemon")
	private long idpokemon;

	@Column(name="idequipo")
	private long idequipo;

	@ManyToOne
	@JoinColumn(name = "id_pokemon")
	private Pokemon pokemon;

	@ManyToOne
	@JoinColumn(name = "id_equipo")
	private Equipo Det_equipo;
}
