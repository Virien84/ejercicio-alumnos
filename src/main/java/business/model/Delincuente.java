package business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DELINCUENTE")
public class Delincuente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7087331123973362373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IDENTIFICADOR", nullable = false, length = 10, unique = true)
	private String identificador;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	@OneToMany(mappedBy = "delincuente")
	private Set<DelincuenteBanda> delincuenteBanda = new HashSet<DelincuenteBanda>();
	
	@OneToMany(mappedBy = "delincuente")
	private List<Atraco> atracos = new ArrayList<Atraco>();
	
	public Delincuente(String identificador, String nombre) {
		this.identificador = identificador;
		this.nombre = nombre;
	}
	
	public Delincuente(Long id) {
		this.id = id;
	}
	
	public Set<DelincuenteBanda> getDelincuenteBanda() {
		return new HashSet<DelincuenteBanda>(delincuenteBanda);
    }
	
	Set<DelincuenteBanda> _getDelincuenteBanda() {
		return delincuenteBanda;
	}

    public void setDelincuenteBanda(Set<DelincuenteBanda> delincuenteBanda) {
        this.delincuenteBanda = delincuenteBanda;
    }
	
	List<Atraco> _getAtracos() {
		return this.atracos;
	}

	public void addAtraco(Atraco atraco) {
		Asociacion.Delinquir.link(this, atraco);
	}

	@Override
	public String toString() {
		return "Delincuente [id=" + id + ", identificador=" + identificador + ", nombre=" + nombre + "]";
	}
	
	public void addDelincuenteBanda(DelincuenteBanda delincuenteBanda) {
		Asociacion.UnirDelincuenteABanda.link(this, delincuenteBanda);
	}
	
	public void removeDelincuenteBanda(DelincuenteBanda delincuenteBanda) {
		Asociacion.UnirDelincuenteABanda.unlink(this, delincuenteBanda);
	}
}
