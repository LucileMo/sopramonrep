package sopramon.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import sopramon.IDAO.IDAOCombat;
import sopramon.IDAO.IDAOCoup;


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