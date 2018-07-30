package sopramon.dao;

import java.util.List;

import game.Utilisateur;

public interface IDAOUtilisateur {

	
	public void findByID();

	public void findByNom();

	Utilisateur findById(int id);

	List<Utilisateur> findAll();
	
	
}
