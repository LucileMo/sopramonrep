package sopramon.IDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopramon.model.Item;
import sopramon.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{

	

	public Utilisateur findByUsernameAndPassword (String username, String password);
	
	public Utilisateur save(Utilisateur entity);
	
	
	
	
}