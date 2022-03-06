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
@Table(name = "ADMINISTRATIVO")
public class Administrativo extends Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3407954607807481314L;
	
	@Column(name = "NNSS",length = 11)
	private String seguridadSocial;
	
	@Column(name = "CC",length = 20)
	private String cuentaBancaria;

	@Override
	public String toString() {
		return super.toString()+"Administrativo [seguridadSocial=" + seguridadSocial + ", cuentaBancaria=" + cuentaBancaria + "]";
	}
}
