package business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.model.Administrativo;

public class AdministrativoDAO implements RepositoryDAO<Administrativo> {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Administrativo insert(Administrativo emp) {
		try {
			em.getTransaction().begin();
			em.persist(emp);
			em.getTransaction().commit();
			return emp;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public void remove(Administrativo emp) {
		try {
			if (emp != null) {
				em.getTransaction().begin();
				em.remove(emp);
				em.getTransaction().commit();
			}
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public void update(Administrativo emp) {
		try {
			if (emp != null) {
				em.getTransaction().begin();
				em.merge(emp);
				em.getTransaction().commit();
			}
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	public Administrativo findById(Long id) {
		Administrativo Administrativo;
		try {
			Administrativo = em.find(Administrativo.class, id);
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return Administrativo;
	}

	public List<Administrativo> findAll() {
		List<Administrativo> administrativos = new ArrayList<Administrativo>();
		try {
			Query query = em.createQuery("SELECT a FROM Administrativo a");
			administrativos = query.getResultList();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return administrativos;
	}

	public List<Administrativo> findByCodigoBanco(String codigoBanco) {
		return em.createNamedQuery("Administrativo.findByCodigoBanco", Administrativo.class).setParameter(1, codigoBanco).getResultList();
	}

	public Administrativo findByDNI(String dni) {
		return em.createNamedQuery("Administrativo.findByDNI", Administrativo.class).setParameter(1, dni).getSingleResult();
	}
}
