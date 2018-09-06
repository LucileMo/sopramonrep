package sopramon.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopramon.dao.IDAOCombat;
import sopramon.dao.IDAOCoup;


@Controller
public class CombatController {
	
/*	
	@GetMapping(value="/Combat")
	public String Accueil(@RequestParam(defaultValue="there") String username, Model model) {
		model.addAttribute("utilisateur", username);
		return "Combat";
	}

*/	
	// LISTER LES COMBATS
	

 	
	@Autowired 
	private IDAOCombat daoCombat;
	
	@Secured({"ROLE_ADMIN, ROLE_USER"})
	
	@GetMapping({ "/Combat" })
	public String listecombat(Model model) {
		 	
	model.addAttribute("combats", daoCombat.findAll());
	
	return "Combat";
	
	
	}


	// HISTORIQUE DES COUPS
	
//	@Autowired 
//	private IDAOCoup daoCoup;
//	
//	@GetMapping({ "/coup" })
//	public String listecoup(Model model) {
//	
//	 model.addAttribute("coups", daoCoup.findAll());
//	
//	 return "Coup";
//	
//	}
	
}