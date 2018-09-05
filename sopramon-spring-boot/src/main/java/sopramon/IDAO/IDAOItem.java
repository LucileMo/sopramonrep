package sopramon.IDAO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopramon.model.Coup;
import sopramon.model.Item;
import sopramon.model.Sopramon;
import sopramon.model.Utilisateur;

public interface IDAOItem extends JpaRepository<Item, Integer> {

	public List <Item> findByNomContaining(String string);
	
	
	// public Utilisateur findByUsernameAndPassword (String username, String
	// password);

	// C CREATE

	public Item save(Item entity);

	// R READ

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
