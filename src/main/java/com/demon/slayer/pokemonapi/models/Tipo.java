package com.demon.slayer.pokemonapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="tipo")
public class Tipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idtipo;
	
	@Column(name="nombretipo")
	private String nombretipo;

}
