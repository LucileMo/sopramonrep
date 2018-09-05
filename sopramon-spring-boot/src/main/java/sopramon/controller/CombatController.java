package sopramon.controller;

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
import sopramon.IDAO.IDAOItem;
import sopramon.model.Combat;
import sopramon.model.Coup;


@Controller
public class CombatController {

	
	// LISTER LES COMBATS
	
	@Autowired 
	private IDAOCombat daoCombat;
	
	@GetMapping({ "/Combat" })
	public String listecombat(Model model) {
		 	
	model.addAttribute("combats", daoCombat.findAll());
	
	return "Combat";

	
	}


	// HISTORIQUE DES COUPS
	
	@Autowired 
	private IDAOCoup daoCoup;
	
	@GetMapping({ "/coup" })
	public String listecoup(Model model) {
	
	 model.addAttribute("coups", daoCoup.findAll());
	
	 return "Coup";
	
	}
	
}