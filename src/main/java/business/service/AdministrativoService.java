package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.AdministrativoDAO;
import business.model.Administrativo;

public class AdministrativoService {
	private AdministrativoDAO administrativoDAO;

	public AdministrativoService() {
		super();
		administrativoDAO = new AdministrativoDAO();
	}

	public List<Administrativo> findAll() throws PersistenceException {
		return administrativoDAO.findAll();
	}

	public Administrativo findById(Long id) throws PersistenceException {
		return administrativoDAO.findById(id);
	}

	public Administrativo insert(Administrativo administrativo) throws PersistenceException {
		return administrativoDAO.insert(administrativo);
	}

	public void update(Administrativo administrativo) throws PersistenceException {
		administrativoDAO.update(administrativo);
	}

	public void delete(Administrativo administrativo) throws PersistenceException {
		administrativoDAO.remove(administrativo);
	}
	
	public List<Administrativo> findByCodigoBanco(String codigoBanco){
		return administrativoDAO.findByCodigoBanco(codigoBanco);
	}
}
