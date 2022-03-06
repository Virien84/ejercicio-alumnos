package business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.model.Sucursal;

public class SucursalDAO implements RepositoryDAO<Sucursal> {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Sucursal insert(Sucursal t) {
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

	public void remove(Sucursal t) {
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

	public void update(Sucursal t) {
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

	public Sucursal findById(Long id) {
		Sucursal sucursal = new Sucursal();
		try {
			sucursal = em.find(Sucursal.class, id);
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return sucursal;
	}

	public List<Sucursal> findAll() {
		List<Sucursal> sucursal = new ArrayList<Sucursal>();
		try {
			Query query = em.createQuery("SELECT s FROM Sucursal s");
			sucursal = query.getResultList();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return sucursal;
	}

	public List<Sucursal> findByCodigoBanco(String codigoBanco) {
		return em.createNamedQuery("Sucursal.findByCodigoBanco", Sucursal.class).setParameter(1, codigoBanco).getResultList();
	}

	public Sucursal findByCodigo(String codigo) {
		return em.createNamedQuery("Sucursal.findByCodigo", Sucursal.class).setParameter(1, codigo).getSingleResult();
	}
}
