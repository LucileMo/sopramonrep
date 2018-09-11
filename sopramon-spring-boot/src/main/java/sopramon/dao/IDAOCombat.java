package sopramon.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import sopramon.model.Combat;
import sopramon.model.Item;


public interface IDAOCombat extends JpaRepository<Combat, Integer> {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Item save(Item entity);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Combat save(Combat combat);
	
}

