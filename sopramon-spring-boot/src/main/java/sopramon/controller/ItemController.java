package sopramon.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import sopramon.dao.IDAOCombat;
import sopramon.dao.IDAOItem;
import sopramon.model.Capacite;
import sopramon.model.Combat;
import sopramon.model.Item;

@Controller
@Secured({"ROLE_ADMIN"})
public class ItemController {

	
	// LISTER LES ITEMS

		@Autowired 
		private IDAOItem daoItem;
	
		@Secured({"ROLE_ADMIN, ROLE_USER"})
		@GetMapping({ "/Espace-sopramon" })
		 
		 public String listeitem(Model model) {
		 	
		 model.addAttribute("items", daoItem.findAll());
		
		 return "Espace-sopramon";
		
		}
	
			
	// AJOUTER ITEM
	
								// Partie 1 GET POUR RECUPERER FORMULAIRE
	
		@GetMapping({ "/additems" })				//fichier html
		public String addItem (Model model) {
	
		return "itemform";							//nom de la vue
		
		}
		
								// Partie 2 POST POUR ENVOYER DONNES
				
		@PostMapping({ "/additems" })
		public String addItem(@RequestParam String nom, @RequestParam float prix, @RequestParam int attaque, @RequestParam int pointsdevie, 
				@RequestParam int defense, @RequestParam int esquive, @RequestParam int vitesse) {
		
		Item myItem = new Item();
		Capacite myCapacite = new Capacite();	
		
	
		myCapacite.setAttaque(attaque);
		myCapacite.setDefense(defense);
		myCapacite.setEsquive(esquive);
		myCapacite.setVitesse(vitesse);
		myCapacite.setPointsdevie(pointsdevie);
		
		myItem.setCapacite(myCapacite);
		myItem.setNom(nom);
		myItem.setPrix(prix);
		
		daoItem.save(myItem);
				
		return "redirect:/Espace-sopramon";
			
		}
	
	// MODIFIER ITEM
		
		@GetMapping({ "/moditems" })
		
		public String editerItem(@RequestParam int id, Model model) {
	
		model.addAttribute("item",  daoItem.findById(id));
	
		return "itemform";
		
		}

		@PostMapping({ "/moditems" })
	
		public String editerItem(@RequestParam int id, @RequestParam String nom, @RequestParam float prix, @RequestParam int capaciteId, @RequestParam int attaque, 
				@RequestParam int pointsdevie, @RequestParam int defense, @RequestParam int esquive, @RequestParam int vitesse) {							{
		
		Item myItem = new Item();
		Capacite myCapacite = new Capacite();
		
		myItem.setId(id);
		myCapacite.setId(capaciteId);
		
		myCapacite.setAttaque(attaque);
		myCapacite.setDefense(defense);
		myCapacite.setEsquive(esquive);
		myCapacite.setVitesse(vitesse);
		myCapacite.setPointsdevie(pointsdevie);
		
		myItem.setCapacite(myCapacite);
		myItem.setNom(nom);
		myItem.setPrix(prix);
		
		daoItem.save(myItem);
				
		return "redirect:/Espace-sopramon";
				}	
				}


	// EFFACER ITEM
	
	@GetMapping({ "/deleteitems" })

	public String deleteItem(@RequestParam int id) {

	daoItem.deleteById(id);
			
	return "redirect:/listitems";
		
	}
	// ACHETER ITEM
	
	@GetMapping({ "/shop" })
	
	public String acheteritems(@RequestParam int id) {

		
				
		return "/shop";
	}


}

