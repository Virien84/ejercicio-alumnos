package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.ContratoDAO;
import business.model.Contrato;

public class ContratoService {
	private ContratoDAO ContratoDAO;

	public ContratoService() {
		super();
		ContratoDAO = new ContratoDAO();
	}

	public List<Contrato> findAll() throws PersistenceException {
		return ContratoDAO.findAll();
	}

	public Contrato findById(Long idContrato) throws PersistenceException {
		return ContratoDAO.findById(idContrato);
	}

	public Contrato insert(Contrato contrato) throws PersistenceException {
		return ContratoDAO.insert(contrato);
	}

	public void update(Contrato contrato) throws PersistenceException {
		ContratoDAO.update(contrato);
	}

	public void delete(Contrato contrato) throws PersistenceException {
		ContratoDAO.remove(contrato);
	}

}
