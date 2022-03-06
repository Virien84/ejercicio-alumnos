package business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLEADO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3211514238829002343L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NOMBRE",length = 25)
	private String nombre;
	
	@Column(name = "APELLIDO",length = 25)
	private String apellido;
	
	@Column(name = "DNI",length = 10)
	private String dni;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "BANCO_ID")
	private Banco banco;

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}	
}
