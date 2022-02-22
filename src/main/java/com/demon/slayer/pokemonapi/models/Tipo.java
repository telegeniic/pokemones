package com.demon.slayer.pokemonapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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


	@OneToMany(mappedBy="tipo")
	private List<DetalleTipos> detalleTipos = new ArrayList<>();
	
}
