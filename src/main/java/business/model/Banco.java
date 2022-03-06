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

@Entity
@Table(name = "BANCO")
public class Banco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5303145511746498228L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "SEDE", nullable = false, length = 50)
	private String sede;

//	@Column(name = "NUM_SUCURSALES", nullable = false, columnDefinition = "int default 0")
//	private int numSucursales;

	@OneToMany(mappedBy = "banco")
	private List<Sucursal> sucursales = new ArrayList<Sucursal>();
	
	@OneToMany(mappedBy = "banco")
	private Set<Empleado> empleados = new HashSet<Empleado>();

	public Banco() {
		super();
	}

	public Banco(String codigo, String sede) {
		super();
		this.codigo = codigo;
		this.sede = sede;
	}

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public int getNumEmpleados() {
		return empleados.size();
	}

	//método público que devuelve una copia de la lista de sucursales
	public Set<Empleado> getEmpleados() {
		return new HashSet<Empleado>(empleados);
	}

	//método privado que devuelve las sucursales
	Set<Empleado> _getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public int getNumSucursales() {
		return sucursales.size();
	}

	//método público que devuelve una copia de la lista de sucursales
	public List<Sucursal> getSucursales() {
		return new ArrayList<Sucursal>(sucursales);
	}

	//método privado que devuelve las sucursales
	List<Sucursal> _getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	@Override
	public String toString() {
		return "Banco [id=" + id + ", codigo=" + codigo + ", sede=" + sede + ", numSucursales=" + sucursales.size()
				+ ", sucursales=" + sucursales + "]";
	}

	public void addSucursal(Sucursal sucursal) {
		Asociacion.Pertenece.link(this, sucursal);
	}
	
	public void removeSucursal(Sucursal sucursal) {
		Asociacion.Pertenece.unlink(this, sucursal);
	}
	
	public void addEmpleado(Empleado empleado) {
		Asociacion.Trabaja.link(this, empleado);
	}
	
	public void removeEmpleado(Empleado empleado) {
		Asociacion.Trabaja.unlink(this, empleado);
	}
}
