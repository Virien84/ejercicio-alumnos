package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.DelincuenteBandaDAO;
import business.model.DelincuenteBanda;

public class DelincuenteBandaService {
	private DelincuenteBandaDAO delincuenteBandaDAO;

	public DelincuenteBandaService() {
		super();
		delincuenteBandaDAO = new DelincuenteBandaDAO();
	}

	public List<DelincuenteBanda> findAll() throws PersistenceException {
		return delincuenteBandaDAO.findAll();
	}

	public DelincuenteBanda findById(Long idDB) throws PersistenceException {
		return delincuenteBandaDAO.findById(idDB);
	}

	public DelincuenteBanda insert(DelincuenteBanda delincuenteBanda) throws PersistenceException {
		return delincuenteBandaDAO.insert(delincuenteBanda);
	}

	public void update(DelincuenteBanda delincuenteBanda) throws PersistenceException {
		delincuenteBandaDAO.update(delincuenteBanda);
	}

	public void delete(DelincuenteBanda delincuenteBanda) throws PersistenceException {
		delincuenteBandaDAO.remove(delincuenteBanda);
	}
	public List<DelincuenteBanda> findByCodigoBanda(Long id){
		return delincuenteBandaDAO.findByCodigoBanda(id);
	}
}
