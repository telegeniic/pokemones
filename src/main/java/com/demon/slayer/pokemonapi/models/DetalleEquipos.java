package com.demon.slayer.pokemonapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="detalleequipos")
public class DetalleEquipos {

	@Id
	private long id;

	@Column(name="idpokemon")
	private long idpokemon;

	@Column(name="idequipo")
	private long idequipo;

}
