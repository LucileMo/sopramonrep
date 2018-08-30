package EntityManagerPrincipal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMPrincipal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
	
	EntityManager em = emf.createEntityManager();

	
	//daoP.findById(1)
	}
}
