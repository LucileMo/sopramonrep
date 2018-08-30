package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopramon.IDAO.IDAOCombat;
import sopramon.IDAO.IDAOCoup;
import sopramon.model.Combat;
import sopramon.model.Coup;


@Controller
public class CombatController {

	
	// LISTER LES COMBATS
	

	@Autowired 
	private IDAOCombat daoCombat;
	
	@GetMapping({ "/combat" })
	public String listecombat(Model model) {
	
	 List<Combat> myCombats = new ArrayList<Combat>();
	 myCombats = daoCombat.findAll();
	 	
	 model.addAttribute("combats", daoCombat.findAll());
	
	return "combat";
	
	}

	// HISTORIQUE DES COUPS
	
	@Autowired 
	private IDAOCoup daoCoup;
	
	@GetMapping({ "/coup" })
	public String listecoup(Model model) {
	
	 List<Coup> myCoups = new ArrayList<Coup>();
	 myCoups = daoCoup.findAll();
	 	
	 model.addAttribute("coups", daoCoup.findAll());
	
	 return "coup";
	
	}
	
	
	
}