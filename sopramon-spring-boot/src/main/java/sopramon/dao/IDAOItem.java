package sopramon.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import sopramon.model.Coup;
import sopramon.model.Item;
import sopramon.model.Sopramon;
import sopramon.model.Utilisateur;
@CrossOrigin("*")
public interface IDAOItem extends JpaRepository<Item, Integer> {

	public List <Item> findByNomContaining(String string);
	
	// public Utilisateur findByUsernameAndPassword (String username, String
	// password);

	// C CREATE
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Item save(Item entity);

	// R READ
	@RestResource(path="by-nom")
	public List<Item> findAll();

	public Item findById(int id);
	
//	@Query
//	public Item findUnItem(@Param("Hache") String libelle);

	// U UPDATE

	//@Query("update i from Item s where s.id = :1, ")
//	Stream<Item> updateAnItem(int String);

	// D DELETE
	
	public Item deleteById(int itemid);

}
