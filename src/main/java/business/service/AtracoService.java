package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.AtracoDAO;
import business.model.Atraco;

public class AtracoService {
	private AtracoDAO atracoDAO;

	public AtracoService() {
		super();
		atracoDAO = new AtracoDAO();
	}

	public List<Atraco> findAll() throws PersistenceException {
		return atracoDAO.findAll();
	}

	public Atraco findById(Long idDelincuente) throws PersistenceException {
		return atracoDAO.findById(idDelincuente);
	}

	public Atraco insert(Atraco atraco) throws PersistenceException {
		return atracoDAO.insert(atraco);
	}

	public void update(Atraco atraco) throws PersistenceException {
		atracoDAO.update(atraco);
	}

	public void delete(Atraco atraco) throws PersistenceException {
		atracoDAO.remove(atraco);
	}

}
