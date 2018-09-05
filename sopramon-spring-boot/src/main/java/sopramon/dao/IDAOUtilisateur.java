package sopramon.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import sopramon.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{

	
	
	public Utilisateur save(Utilisateur entity);
	
	public Utilisateur findByUsername(String username);
	
	
	
	
	
}