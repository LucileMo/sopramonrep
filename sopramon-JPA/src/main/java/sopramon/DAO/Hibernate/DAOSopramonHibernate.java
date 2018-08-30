
package sopramon.DAO.Hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import sopramon.DAO.IDAOSopramon;
import sopramon.model.Sopramon;
import sopramon.model.Utilisateur;


public class DAOSopramonHibernate extends DAOHibernate implements IDAOSopramon {
	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NomPersistenceUnit");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx;

		/*
		 * EntityTransaction tx = em.getTransaction(); //Récupérer la transaction
		 * tx.begin(); //Démarrer la transaction tx.commit(); //Appliquer les
		 * traitements en base de données tx.rollback(); //Annuler les traitements
		 */

		public List<Sopramon> findAll() {
			return em.createQuery("select s from Soprampon s", Sopramon.class).getResultList();
		}

		public Sopramon findByID(int id) {
			return em.find(Sopramon.class, id);
		}

		public Sopramon save(Sopramon entity) {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

			return entity;
		}

		public void delete(Sopramon entity) {
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();

		}

		public void deleteById(int id) {
			Sopramon mySopramon = new Sopramon();
			mySopramon.setId(id);
			delete(mySopramon);

		}

		public Sopramon findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}


	/*	public List<Combat> findByGammeFournisseurId(int fournisseurId) {
			// TODO Auto-generated method stub
			return null;
		}
	*/
		

public Sopramon findByUtilisateur(String username, String password) {
	
	
	return em
			.createQuery("select s from Sopramon s where s.username = :username and s.password = :password", Sopramon.class)
			.setParameter("username", username )
			.setParameter("password", password )
			.getSingleResult();

}

	
}



