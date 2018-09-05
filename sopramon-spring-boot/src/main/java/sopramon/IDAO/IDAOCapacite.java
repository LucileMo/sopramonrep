package sopramon.IDAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopramon.model.Capacite;
import sopramon.model.Combat;


public interface IDAOCapacite extends JpaRepository<Capacite, Integer> {
	
	public Capacite save(Capacite entity);	
	
}

