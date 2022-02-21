package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="detalletipos")
public class DetalleTipos {
	
	@Column(name="idpokemon")
	private long idpokemon;
	
	@Column(name="idtipo")
	private long id;
	
	
}
