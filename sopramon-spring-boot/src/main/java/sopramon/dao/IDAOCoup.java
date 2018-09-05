package sopramon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopramon.model.Coup;
import sopramon.model.Sopramon;

	
	public interface IDAOCoup extends JpaRepository<Coup, Integer> {
		
		//@Query("select c from Coup s where s.id = :1")
		//public Sopramon findUnCoup(@Param("1") String id);
		
	//	public List<Coup> findByPrixBetween(double prix1, double prix2);
		
		//public Coup save (Coup entity);
		
		//public List<Coup> findByCoupid(String libelle);
		
		//public List<Coup> findByPrix(String libelle);

		//public Coup findFirstByNom(String libelle);

		//public List<Coup> findTop10ByNomContainingOrderByIdDesc(String libelle);

		//public int countByCoupidContaining(String libelle);
		
		
	}
	 