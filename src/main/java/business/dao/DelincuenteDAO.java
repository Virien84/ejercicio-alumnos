package business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.model.Delincuente;

public class DelincuenteDAO implements RepositoryDAO<Delincuente> {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void remove(Delincuente t) {
		try {
			if (t != null) {
				em.getTransaction().begin();
				em.remove(t);
				em.getTransaction().commit();
			}
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public Delincuente findById(Long id) {
		Delincuente delincuente = new Delincuente();
		try {
			delincuente = em.find(Delincuente.class, id);
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return delincuente;
	}

	public List<Delincuente> findAll() {
		List<Delincuente> delincuentes = new ArrayList<Delincuente>();
		try {
			Query query = em.createQuery("SELECT d FROM Delincuente d");
			delincuentes = query.getResultList();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return delincuentes;
	}

	public Delincuente insert(Delincuente t) {
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

	public void update(Delincuente t) {
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

}
