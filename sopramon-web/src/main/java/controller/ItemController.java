package controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopramon.IDAO.IDAOCombat;
import sopramon.IDAO.IDAOItem;
import sopramon.model.Capacite;
import sopramon.model.Combat;
import sopramon.model.Item;

@Controller
public class ItemController {

	
	// LISTER LES ITEMS

	@Autowired 
	private IDAOItem daoItem;
	
	@GetMapping({ "/listeritems" })
	public String listeitem(Model model) {
	
	 	
	 model.addAttribute("items", daoItem.findAll());
	
	 return "Espace-sopramon";
	
	}
	
/*
	// AJOUTER ITEM
	
	// Partie 1 GET POUR RECUPERER FORMULAIRE
	// (@RequestParam(value="id", required=true, defaultValue="1") int id, Model model)
	
		@GetMapping({ "/additem" })
		public String addItem (Model model) {
	
		model.addAttribute("items", daoItem.findAll());
	
		return "itemform";

		}

	// Partie 2 POST POUR ENVOYER DONNES
		
		
		@PostMapping({ "/additem" })
		public String addProduit(@RequestParam String nom, @RequestParam float prix, @RequestParam Capacite capacite) {
		
		Item myItem = new Item();
			
		myItem.setNom(nom);
		myItem.setPrix(prix);
	    myItem.setCapacite(capacite);
			
		daoItem.save(myItem);
				

		return "redirect:/espacAdmin";
		
		/*		
		}
		
		// EFFACER ITEM
		
		@GetMapping({ "/deleteitem" })

		public String deleteItem(@RequestParam int id) {
	
		daoItem.deleteById(id);
				
		return "redirect:/espaceAdmin";
		
	
		}
		
		// MODIFIER ITEM
		
		@GetMapping({ "/moditem" })
	
		public String editerProduit(@RequestParam int id, Model model) {
	
		model.addAttribute("item",  daoItem.findById(id).get());
	
		return "espaceAdmin";
		
		}
	
	@PostMapping({ "/moditem" })
	
		public String editerItem(@ModelAttribute Item item) {
	
		myItem.setNom(nom);
		myItem.setPrix(prix);
	    myItem.setCapacite(capacite);
			
		daoItem.save(myItem);
				
		return "redirect:/espaceAdmin";
	
		}
*/		
}


