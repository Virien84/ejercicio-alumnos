package business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import business.model.BandaOrganizada;

public class BandaOrganizadaDAO implements RepositoryDAO<BandaOrganizada>{
	
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public BandaOrganizada insert(BandaOrganizada t) {
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

	public void remove(BandaOrganizada t) {
		// TODO Auto-generated method stub
		
	}

	public void update(BandaOrganizada t) {
		// TODO Auto-generated method stub
		
	}

	public BandaOrganizada findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BandaOrganizada> findAll() {
		List<BandaOrganizada> bandas = new ArrayList<BandaOrganizada>();
		try {
			Query query = em.createQuery("SELECT b FROM BandaOrganizada b");
			bandas = query.getResultList();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return bandas;
	}
	public BandaOrganizada findByCodigo(String codigo) {
		return em.createNamedQuery("BandaOrganizada.findByCodigo", BandaOrganizada.class).setParameter(1, codigo).getSingleResult();
	}
}
