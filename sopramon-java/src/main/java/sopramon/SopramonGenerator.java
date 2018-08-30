package sopramon;

import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import sopramon.IDAO.IDAOItem;
import sopramon.IDAO.IDAOSopramon;
import sopramon.IDAO.IDAOCombat;

import sopramon.IDAO.IDAOUtilisateur;
import sopramon.model.Item;
import sopramon.model.Sopramon;
import sopramon.model.Utilisateur;

public class SopramonGenerator {

	static int lireEntier() {

		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextInt();
		}

		catch (Exception ex) {
			return 0;

		}

	}

	static String lireChaine() {
		Scanner myScanner = new Scanner(System.in);
		try {
			return myScanner.next();
		} catch (Exception ex) {
			return null;
		}
	}

	@Autowired
	IDAOItem daoitem;

	public void run(String[] args) {
		
		int m = 0;
		while (m < 1 || m > 3) {
			System.out.println("....................");
			System.out.println("........menu........");
			System.out.println("....................");
			System.out.println("Saisir un mode : ");
			
			System.out.println("1 : Ajouter un Item");

			System.out.println("2 : Supprimer un Item");

			System.out.println("3 : Modifier un Item");
			
			m = lireEntier();

		switch (m) {
		case 1:
			Item myItem = new Item();

			System.out.println("....................");
			System.out.println("Ajouter un item : ");
			System.out.println("....................");		
			
			System.out.println("Saisir le nom de l'item : ");
				String u = lireChaine();
				myItem.setNom(u);
				
				System.out.println("Saisir le prix de l'item : ");
				int p = lireEntier();
				myItem.setPrix(p);
				
				System.out.println("Saisir la capacité de l'item : ");
				String q = lireChaine();
				myItem.setCapacite(q);

				System.out.println("Saisir le stock de l'item : ");
				int r = lireEntier();
				myItem.setStock(r);
				
				daoitem.save(myItem);
			
				
	/*			S SAVE ITEM

				Item myItem = new Item();

				myItem.setNom("Le DESTRUCTOR");
				myItem.setPrix(400);
				myItem.setCapacite("12");
				myItem.setStock(500);

				daoitem.save(myItem);
	*/			
				break;	
		
		case 2:
		
			System.out.println("....................");
			System.out.println("Suppression d'un item : ");
			System.out.println("....................");		
			
		
			
			System.out.println("Saisir l'Id de l'item : ");
			int i = lireEntier();
			daoitem.deleteById(i);
			
				break;

		case 3:

			Item myItemAModifier;
			
			System.out.println("....................");
			System.out.println("Modification d'un item : ");
			System.out.println("....................");
			
			System.out.println("Saisir l'Id de l'item à modifier : ");
			int a = lireEntier();
			
			myItemAModifier = daoitem.findById(a).get();
						
//		for (Item myItemAModifier : updateAnItem(a)) {
			
			System.out.println("Saisir le nouveau nom de l'item : ");
			String b = lireChaine();
	//		System.out.println("Changement de nom pour " + "myItemAModifier.setNom(b));
			myItemAModifier.setNom(b);
			
			System.out.println("Saisir le nouveau prix de l'item : ");
			int c = lireEntier();
			myItemAModifier.setPrix(c);
			
			System.out.println("Saisir la nouvelle capacité de l'item : ");
			String d = lireChaine();
			myItemAModifier.setCapacite(d);
			
			System.out.println("Saisir le nouveau stock de l'item : ");
			int e = lireEntier();
			myItemAModifier.setStock(e);
			
			System.out.println("-----------------------------");
			
			daoitem.save(myItemAModifier);
			
		break;
			
		}
		
		}
	}
}

	
		

/*			
  			System.out.println("Saisir le nouveau nom de l'item : ");
			String b = lireChaine();
			myItemAModifier.setNom(b);
			
			System.out.println("Saisir le nouveau prix de l'item : ");
			int c = lireEntier();
			myItemAModifier.setPrix(c);
			
			System.out.println("Saisir la nouvelle capacité de l'item : ");
			String d = lireChaine();
			myItemAModifier.setCapacite(d);

			System.out.println("Saisir le nouveau stock de l'item : ");
			int e = lireEntier();
			myItemAModifier.setStock(e);
			
			daoitem.save(myItemAModifier);		
*/			
			
			/*
			
			
getStock
getId
getNom
getCapacite
getPrix

			
			
			 */



		//	U UPDATE

		//	@Query("update i from Item s where s.id = :1, ")
		//	Stream<Item> updateAnItem();
			
			
//			Item myItem = new Item();
//			daoproduit.findUnProduit("Planche");
//			daoproduit.findByNom("planche"); 
			
			
			
	//	D DELETE ITEM BY ID

//		daoitem.deleteById(13);

		


//	daoitem.updateAnItem(1);

//Item myItem = new Item();
//daoproduit.findUnProduit("Planche");
//daoproduit.findByNom("planche"); 

// Ajout d'un Utilisateur/Sopramon
/*
 * daoUtilisateur = new DAOUtilisateurHibernate(); Utilisateur myUtilisateur =
 * new Utilisateur();
 * 
 * myUtilisateur.setNom(""); myUtilisateur.setPrenom("");
 * myUtilisateur.setUsername(""); myUtilisateur.setPassword("");
 * 
 * daoUtilisateur.save(myUtilisateur);
 */

// Ajout d'un Item
/*
 * IDAOItem daoItem = new DAOItemHibernate(); Item myItem = new Item();
 * 
 * myItem.setNom("Arc"); myItem.setPrix(54);
 * myItem.setCapacite("Tire des fleches"); myItem.setStock(58);
 * 
 * daoItem.save(myItem);
 * 
 * 
 */
