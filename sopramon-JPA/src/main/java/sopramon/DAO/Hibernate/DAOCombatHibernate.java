package sopramon.DAO.Hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sopramon.DAO.IDAOCombat;
import sopramon.model.Combat;



public class DAOCombatHibernate	extends DAOHibernate implements IDAOCombat {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
	EntityManager em = emf.createEntityManager();

	EntityTransaction tx;

	/*
	 * EntityTransaction tx = em.getTransaction(); //Récupérer la transaction
	 * tx.begin(); //Démarrer la transaction tx.commit(); //Appliquer les
	 * traitements en base de données tx.rollback(); //Annuler les traitements
	 */

	public List<Combat> findAll() {
		return em.createQuery("select c from Combat c", Combat.class).getResultList();
	}

	public Combat findByID(int id) {
		return em.find(Combat.class, id);
	}

	public Combat save(Combat entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();

		return entity;
	}

	public void delete(Combat entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();

	}

	public void deleteById(int id) {
		Combat myCombat = new Combat();
		myCombat.setId(id);
		delete(myCombat);

	}

	public Combat findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

/*	public List<Combat> findByGammeFournisseurId(int fournisseurId) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
}
