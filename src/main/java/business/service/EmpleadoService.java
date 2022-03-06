package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.EmpleadoDAO;
import business.model.Empleado;

public class EmpleadoService {
	private EmpleadoDAO empleadoDAO;

	public EmpleadoService() {
		super();
		empleadoDAO = new EmpleadoDAO();
	}

	public List<Empleado> findAll() throws PersistenceException {
		return empleadoDAO.findAll();
	}

	public Empleado findById(Long id) throws PersistenceException {
		return empleadoDAO.findById(id);
	}

	public Empleado insert(Empleado empleado) throws PersistenceException {
		return empleadoDAO.insert(empleado);
	}

	public void update(Empleado empleado) throws PersistenceException {
		empleadoDAO.update(empleado);
	}

	public void delete(Empleado empleado) throws PersistenceException {
		empleadoDAO.remove(empleado);
	}
	
	public List<Empleado> findByCodigoBanco(String codigoBanco){
		return empleadoDAO.findByCodigoBanco(codigoBanco);
	}

	public Empleado findByDNI(String dni) {
		return empleadoDAO.findByDNI(dni);
	}
}
