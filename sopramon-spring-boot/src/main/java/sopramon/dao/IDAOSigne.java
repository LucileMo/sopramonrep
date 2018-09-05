package sopramon.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sopramon.model.Combat;
import sopramon.model.Item;
import sopramon.model.Signe;
import sopramon.model.Utilisateur;


public interface IDAOSigne extends JpaRepository<Signe, Integer> {
	
	public Signe save(Signe entity);
	
	
}

