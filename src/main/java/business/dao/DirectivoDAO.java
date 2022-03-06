package business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.model.Directivo;

public class DirectivoDAO implements RepositoryDAO<Directivo> {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Directivo insert(Directivo dir) {
		try {
			em.getTransaction().begin();
			em.persist(dir);
			em.getTransaction().commit();
			return dir;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public void remove(Directivo dir) {
		try {
			if (dir != null) {
				em.getTransaction().begin();
				em.remove(dir);
				em.getTransaction().commit();
			}
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public void update(Directivo dir) {
		try {
			if (dir != null) {
				em.getTransaction().begin();
				em.merge(dir);
				em.getTransaction().commit();
			}
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public Directivo findById(Long id) {
		Directivo directivo;
		try {
			directivo = em.find(Directivo.class, id);
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return directivo;
	}

	public List<Directivo> findAll() {
		List<Directivo> directivos = new ArrayList<Directivo>();
		try {
			Query query = em.createQuery("SELECT d FROM Directivo d");
			directivos = query.getResultList();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return directivos;
	}

	public List<Directivo> findByCodigoBanco(String codigoBanco) {
		return em.createNamedQuery("Directivo.findByCodigoBanco", Directivo.class).setParameter(1, codigoBanco).getResultList();
	}
}
