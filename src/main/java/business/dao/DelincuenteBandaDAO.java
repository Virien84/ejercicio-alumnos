package business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import business.model.DelincuenteBanda;

public class DelincuenteBandaDAO implements RepositoryDAO<DelincuenteBanda>{
	
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public DelincuenteBanda insert(DelincuenteBanda delincuenteBanda) {
		try {
			em.getTransaction().begin();
			em.persist(delincuenteBanda);
			em.getTransaction().commit();
			return delincuenteBanda;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public void remove(DelincuenteBanda t) {
		// TODO Auto-generated method stub
		
	}

	public void update(DelincuenteBanda t) {
		// TODO Auto-generated method stub
		
	}

	public DelincuenteBanda findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DelincuenteBanda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<DelincuenteBanda> findByCodigoBanda(Long id) {
		return em.createNamedQuery("DelincuenteBanda.findByCodigoBanda", DelincuenteBanda.class).setParameter(1, id).getResultList();
	}
}
