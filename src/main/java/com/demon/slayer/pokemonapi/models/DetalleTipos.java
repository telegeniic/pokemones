package com.demon.slayer.pokemonapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="detalletipos")
public class DetalleTipos {

	@Id
	@Column(name="idpokemon")
	private long idpokemon;

	@Column(name="idtipo")
	private long id;
	
	
}
