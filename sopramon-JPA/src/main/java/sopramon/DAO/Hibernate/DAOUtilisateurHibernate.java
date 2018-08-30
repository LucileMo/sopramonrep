package sopramon.DAO.Hibernate;

import java.util.List;

import sopramon.DAO.IDAOItem;
import sopramon.DAO.IDAOUtilisateur;
import sopramon.model.Item;
import sopramon.model.Sopramon;
import sopramon.model.Utilisateur;


public class DAOUtilisateurHibernate extends DAOHibernate implements IDAOUtilisateur {
	

	
	 
	
	public List<Utilisateur> findAll() {
		return em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
	}
	
	
	public Utilisateur save(Utilisateur entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
		}
		
	
	
		public Utilisateur findById(int id) {
		return em.find(Utilisateur.class, id);
		}
		
	
	
		public void delete(Utilisateur entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		}
	
	
	public void deleteById(int id) {
		Utilisateur myUtilisateur = new Utilisateur();
		myUtilisateur.setId(id);
		delete(myUtilisateur);
	}


	public List<Utilisateur> findByAchatsUtilisateurtId(int UtilisateurId) {
		return em
				.createQuery("select distinct c from Utilisateur c left join fetch c.achats a where a.client.id = :clientId", Utilisateur.class)
				.setParameter("UtilisateurId", UtilisateurId)
				.getResultList();
	}


	public List<Utilisateur> findByGammeFournisseurId(int fournisseurId) {
		return em
				.createQuery("select distinct p from Produit p where p.gamme.fournisseur.id = :fournisseurId", Utilisateur.class)
				.setParameter("fournisseurId", fournisseurId)
				.getResultList();
	
	
	
}
	
}






