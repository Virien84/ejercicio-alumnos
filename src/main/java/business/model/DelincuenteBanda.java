package business.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DELINCUENTE_BANDA")
public class DelincuenteBanda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7421974046128067070L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "DELINCUENTE_ID")
	private Delincuente delincuente;
	
	@ManyToOne
	@JoinColumn(name = "BANDA_ID")
	private BandaOrganizada bandaOrganizada;
	
	public Delincuente getDelincuente() {
        return delincuente;
    }

    public void setDelincuente(Delincuente delincuente) {
        this.delincuente = delincuente;
    }

    public BandaOrganizada getBanda() {
        return bandaOrganizada;
    }

    public void setBanda(BandaOrganizada banda) {
        this.bandaOrganizada = banda;
    }

	@Override
	public String toString() {
		return "DelincuenteBanda [id=" + id + "]";
	}
}
