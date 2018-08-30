package sopramon.DAO.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOHibernate {
	protected static EntityManagerFactory emf;
	protected static EntityManager em;
	
	
	public DAOHibernate() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("NomPersistenceUnit");
			em = emf.createEntityManager();
		}
	}
	
	
	public static void close() {
		em.close();
		emf.close();
	}
}
