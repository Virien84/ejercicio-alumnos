package business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DIRECTIVO")
public class Directivo extends Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7625605691882873343L;
	
	@Column(name = "NIVEL",length = 20)
	private String nivel;
	
	@Column(name = "CARGO",length = 20)
	private String cargo;

	@Override
	public String toString() {
		return super.toString()+"Directivo [nivel=" + nivel + ", cargo=" + cargo + "]";
	}
}
