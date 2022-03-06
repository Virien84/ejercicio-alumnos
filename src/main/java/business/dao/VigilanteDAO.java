package business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import business.model.Vigilante;

public class VigilanteDAO implements RepositoryDAO<Vigilante>{
	
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Vigilante insert(Vigilante t) {
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

	public void remove(Vigilante t) {
		// TODO Auto-generated method stub
		
	}

	public void update(Vigilante t) {
		// TODO Auto-generated method stub
		
	}

	public Vigilante findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Vigilante> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
