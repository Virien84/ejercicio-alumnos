package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.JuezDAO;
import business.model.Juez;

public class JuezService {
	private JuezDAO juezDAO;

	public JuezService() {
		super();
		juezDAO = new JuezDAO();
	}

	public List<Juez> findAll() throws PersistenceException {
		return juezDAO.findAll();
	}

	public Juez findById(Long idJuez) throws PersistenceException {
		return juezDAO.findById(idJuez);
	}

	public Juez insert(Juez juez) throws PersistenceException {
		return juezDAO.insert(juez);
	}

	public void update(Juez juez) throws PersistenceException {
		juezDAO.update(juez);
	}

	public void delete(Juez juez) throws PersistenceException {
		juezDAO.remove(juez);
	}

}
