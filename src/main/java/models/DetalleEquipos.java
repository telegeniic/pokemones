package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="detalleequipos")
public class DetalleEquipos {
	
	@Column(name="idpokemon")
	private long idpokemon;
	
	@Column(name="idequipo")
	private long idequipo;

}
