package business.service;

import java.util.List;

import javax.persistence.PersistenceException;

import business.dao.DirectivoDAO;
import business.model.Directivo;

public class DirectivoService {
	private DirectivoDAO directivoDAO;

	public DirectivoService() {
		super();
		directivoDAO = new DirectivoDAO();
	}

	public List<Directivo> findAll() throws PersistenceException {
		return directivoDAO.findAll();
	}

	public Directivo findById(Long id) throws PersistenceException {
		return directivoDAO.findById(id);
	}

	public Directivo insert(Directivo directivo) throws PersistenceException {
		return directivoDAO.insert(directivo);
	}

	public void update(Directivo directivo) throws PersistenceException {
		directivoDAO.update(directivo);
	}

	public void delete(Directivo directivo) throws PersistenceException {
		directivoDAO.remove(directivo);
	}
	
	public List<Directivo> findByCodigoBanco(String codigoBanco){
		return directivoDAO.findByCodigoBanco(codigoBanco);
	}
}
