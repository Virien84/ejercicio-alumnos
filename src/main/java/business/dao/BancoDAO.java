package business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.model.Banco;

public class BancoDAO implements RepositoryDAO<Banco> {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void remove(Banco t) {
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

	public Banco findById(Long id) {
		Banco banco = new Banco();
		try {
			banco = em.find(Banco.class, id);
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return banco;
	}

	public List<Banco> findAll() {
		List<Banco> bancos = new ArrayList<Banco>();
		try {
			Query query = em.createQuery("SELECT b FROM Banco b");
			bancos = query.getResultList();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return bancos;
	}

	public Banco insert(Banco t) {
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

	public void update(Banco t) {
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

	public Banco findByCodigo(String codigo) {
		return em.createNamedQuery("Banco.findByCodigo", Banco.class).setParameter(1, codigo).getSingleResult();
	}

}
