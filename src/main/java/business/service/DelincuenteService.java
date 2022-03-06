package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.DelincuenteDAO;
import business.model.Delincuente;

public class DelincuenteService {
	private DelincuenteDAO delincuenteDAO;

	public DelincuenteService() {
		super();
		delincuenteDAO = new DelincuenteDAO();
	}

	public List<Delincuente> findAll() throws PersistenceException {
		return delincuenteDAO.findAll();
	}

	public Delincuente findById(Long idDelincuente) throws PersistenceException {
		return delincuenteDAO.findById(idDelincuente);
	}

	public Delincuente insert(Delincuente delincuente) throws PersistenceException {
		return delincuenteDAO.insert(delincuente);
	}

	public void update(Delincuente delincuente) throws PersistenceException {
		delincuenteDAO.update(delincuente);
	}

	public void delete(Delincuente delincuente) throws PersistenceException {
		delincuenteDAO.remove(delincuente);
	}

}
