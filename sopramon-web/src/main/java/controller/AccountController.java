package controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import sopramon.IDAO.IDAOSopramon;
import sopramon.IDAO.IDAOUtilisateur;

@Controller
public class AccountController {
	
	
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@Autowired
	private IDAOSopramon daoSopramon;
	
	
	@GetMapping("/Connexion")
	public String login() {
		
	return "Connexion";
	}
	
	@PostMapping("/Connexion")
	public String check(@RequestParam String username, @RequestParam String password, Model model) {
		
	if(daoUtilisateur.findByUsernameAndPassword(username, password) == null){
		
		model.addAttribute("msgerr","Username ou Password erroné(s)");
        
        return "redirect:/Connexion";
	}
	
	return "redirect:/Espace-sopramon";
	}
	
	

	@GetMapping(value="/Inscription")
	public String create(@RequestParam(defaultValue="there") String username, Model model) {
		model.addAttribute("utilisateur", username);
		return "Inscription";
	}
	@PostMapping(value="/Inscription")
	public String createU(@RequestParam(defaultValue="there") String username, Model model) {
		model.addAttribute("utilisateur", username);
		return "Inscription";
	}
	
	

}