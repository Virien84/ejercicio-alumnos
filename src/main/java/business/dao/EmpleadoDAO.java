package business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.model.Empleado;

public class EmpleadoDAO implements RepositoryDAO<Empleado> {

	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

	public Empleado insert(Empleado emp) {
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

	public void remove(Empleado emp) {
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

	public void update(Empleado emp) {
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

	public Empleado findById(Long id) {
		Empleado empleado;
		try {
			empleado = em.find(Empleado.class, id);
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return empleado;
	}

	public List<Empleado> findAll() {
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			Query query = em.createQuery("SELECT emp FROM Empleado emp");
			empleados = query.getResultList();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return empleados;
	}

	public List<Empleado> findByCodigoBanco(String codigoBanco) {
		return em.createNamedQuery("Empleado.findByCodigoBanco", Empleado.class).setParameter(1, codigoBanco).getResultList();
	}

	public Empleado findByDNI(String dni) {
		return em.createNamedQuery("Empleado.findByDNI", Empleado.class).setParameter(1, dni).getSingleResult();
	}
}
