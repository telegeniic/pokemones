package com.demon.slayer.pokemonapi.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Table(name ="tipo")
@Getter
@Setter
public class Tipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idtipo;
	
	@Column(name="nombretipo")
	private String nombretipo;

	@ManyToMany(mappedBy="tipos")
	private List<Pokemon> pokemons =new ArrayList<>();

	public String getNombretipo() {
		return nombretipo;
	}

    public void setNombretipo(String tipito) {
		this.nombretipo=(tipito);
    }
	
	
}
