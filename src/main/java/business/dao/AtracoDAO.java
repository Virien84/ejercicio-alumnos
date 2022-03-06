package business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import business.model.Atraco;

public class AtracoDAO implements RepositoryDAO<Atraco> {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Atraco insert(Atraco t) {
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

	public void remove(Atraco t) {
		// TODO Auto-generated method stub

	}

	public void update(Atraco t) {
		try {
			if (t != null) {
				em.getTransaction().begin();
				em.merge(t);
				em.getTransaction().commit();
			}
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}

	}

	public Atraco findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Atraco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
