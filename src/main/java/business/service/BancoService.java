package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.BancoDAO;
import business.model.Banco;

public class BancoService {
	private BancoDAO bancoDAO;

	public BancoService() {
		super();
		bancoDAO = new BancoDAO();
	}

	public List<Banco> findAll() throws PersistenceException {
		return bancoDAO.findAll();
	}

	public Banco findById(Long idBanco) throws PersistenceException {
		return bancoDAO.findById(idBanco);
	}

	public Banco insert(Banco banco) throws PersistenceException {
		return bancoDAO.insert(banco);
	}

	public void update(Banco banco) throws PersistenceException {
		bancoDAO.update(banco);
	}

	public void delete(Banco banco) throws PersistenceException {
		bancoDAO.remove(banco);
	}

	public Banco findByCodigo(String codigo) {
		return bancoDAO.findByCodigo(codigo);
	}

}
