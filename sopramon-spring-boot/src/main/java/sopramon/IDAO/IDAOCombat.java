package sopramon.IDAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sopramon.model.Combat;


public interface IDAOCombat extends JpaRepository<Combat, Integer> {
	
	
}

