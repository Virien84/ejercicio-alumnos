package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.VigilanteDAO;
import business.model.Vigilante;

public class VigilanteService {
	private VigilanteDAO VigilanteDAO;

	public VigilanteService() {
		super();
		VigilanteDAO = new VigilanteDAO();
	}

	public List<Vigilante> findAll() throws PersistenceException {
		return VigilanteDAO.findAll();
	}

	public Vigilante findById(Long idVigilante) throws PersistenceException {
		return VigilanteDAO.findById(idVigilante);
	}

	public Vigilante insert(Vigilante vigilante) throws PersistenceException {
		return VigilanteDAO.insert(vigilante);
	}

	public void update(Vigilante vigilante) throws PersistenceException {
		VigilanteDAO.update(vigilante);
	}

	public void delete(Vigilante vigilante) throws PersistenceException {
		VigilanteDAO.remove(vigilante);
	}

}
