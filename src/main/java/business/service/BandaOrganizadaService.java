package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.BandaOrganizadaDAO;
import business.model.BandaOrganizada;

public class BandaOrganizadaService {
	private BandaOrganizadaDAO bandaOrganizadaDAO;

	public BandaOrganizadaService() {
		super();
		bandaOrganizadaDAO = new BandaOrganizadaDAO();
	}

	public List<BandaOrganizada> findAll() throws PersistenceException {
		return bandaOrganizadaDAO.findAll();
	}

	public BandaOrganizada findById(Long idBanda) throws PersistenceException {
		return bandaOrganizadaDAO.findById(idBanda);
	}

	public BandaOrganizada insert(BandaOrganizada bandaOrganizada) throws PersistenceException {
		return bandaOrganizadaDAO.insert(bandaOrganizada);
	}

	public void update(BandaOrganizada bandaOrganizada) throws PersistenceException {
		bandaOrganizadaDAO.update(bandaOrganizada);
	}

	public void delete(BandaOrganizada bandaOrganizada) throws PersistenceException {
		bandaOrganizadaDAO.remove(bandaOrganizada);
	}
	public BandaOrganizada findByCodigo(String codigo) {
		return bandaOrganizadaDAO.findByCodigo(codigo);
	}
}
