package business.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT = "persistencia";
	private static EntityManagerFactory emf;
	
	private JPAUtil() {
		
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		return emf;
	}

	public static void cerrar() {
		if (emf != null) {
			emf.close();
		}
	}
}
