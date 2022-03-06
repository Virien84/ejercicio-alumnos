package business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import business.model.Juez;

public class JuezDAO implements RepositoryDAO<Juez>{
	
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Juez insert(Juez t) {
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

	public void remove(Juez t) {
		// TODO Auto-generated method stub
		
	}

	public void update(Juez t) {
		// TODO Auto-generated method stub
		
	}

	public Juez findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Juez> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
