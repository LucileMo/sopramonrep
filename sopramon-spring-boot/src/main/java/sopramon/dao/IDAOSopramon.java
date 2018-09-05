package sopramon.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopramon.model.Sopramon;
	
	
	public interface IDAOSopramon extends JpaRepository<Sopramon, Integer> {
		
		
		public List<Sopramon> findAll();
		public Sopramon save(Sopramon entity);
		
		
	}
	 