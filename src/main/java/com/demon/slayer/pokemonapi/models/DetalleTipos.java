package com.demon.slayer.pokemonapi.models;

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
@Table(name ="detalletipos")
public class DetalleTipos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="idpokemon")
	private long idpokemon;

	@Column(name="idtipo")
	private long idTipo;
	
	@ManyToOne
	@JoinColumn(name = "id_pokemon")
	private Pokemon tipPokemon;

	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;
	
}
