package business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import business.model.Contrato;

public class ContratoDAO implements RepositoryDAO<Contrato>{
	
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Contrato insert(Contrato t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return t;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public void remove(Contrato t) {
		// TODO Auto-generated method stub
		
	}

	public void update(Contrato t) {
		// TODO Auto-generated method stub
		
	}

	public Contrato findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contrato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
