package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.SucursalDAO;
import business.model.Sucursal;

public class SucursalService {
	private SucursalDAO sucursalDAO;

	public SucursalService() {
		super();
		sucursalDAO = new SucursalDAO();
	}

	public List<Sucursal> findAll() throws PersistenceException {
		return sucursalDAO.findAll();
	}

	public Sucursal findById(Long idSucursal) throws PersistenceException {
		return sucursalDAO.findById(idSucursal);
	}

	public Sucursal insert(Sucursal sucursal) throws PersistenceException {
		return sucursalDAO.insert(sucursal);
	}

	public void update(Sucursal sucursal) throws PersistenceException {
		sucursalDAO.update(sucursal);
	}

	public void delete(Sucursal sucursal) throws PersistenceException {
		sucursalDAO.remove(sucursal);
	}
	
	public List<Sucursal> findByCodigoBanco(String codigoBanco){
		return sucursalDAO.findByCodigoBanco(codigoBanco);
	}

	public Sucursal findByCodigo(String codigo) {
		return sucursalDAO.findByCodigo(codigo);
	}

}
