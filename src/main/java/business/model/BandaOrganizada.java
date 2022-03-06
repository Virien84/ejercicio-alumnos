package business.model;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name = "BANDA_ORGANIZADA")
public class BandaOrganizada implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5644197328475561675L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "NUM_MIEMBROS", nullable = false, columnDefinition = "int default 0")
	private int numMiembros;
	
	@OneToMany(mappedBy = "bandaOrganizada")
	private Set<DelincuenteBanda> delincuenteBanda = new HashSet<DelincuenteBanda>();
	
	public BandaOrganizada(Long id) {
		this.id = id;
	}

	public BandaOrganizada(String codigo, int numMiembros) {
		super();
		this.codigo = codigo;
		this.numMiembros = numMiembros;
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

	@Override
	public String toString() {
		return "BandaOrganizada [id=" + id + ", codigo=" + codigo + ", numMiembros=" + numMiembros + "]";
	}
	
	public void addDelincuenteBanda(DelincuenteBanda delincuenteBanda) {
		Asociacion.UnirBandaADelincuente.link(this, delincuenteBanda);
	}
	
	public void removeDelincuenteBanda(DelincuenteBanda delincuenteBanda) {
		Asociacion.UnirBandaADelincuente.unlink(this, delincuenteBanda);
	}
}
