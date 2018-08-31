package controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopramon.IDAO.IDAOSopramon;
import sopramon.IDAO.IDAOUtilisateur;
import sopramon.model.Sopramon;
import sopramon.model.Utilisateur;

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
	public String inscript() {
		return "Inscription";
	}
	@PostMapping({"/Inscription"})
	public String addUtil(@RequestParam String pseudo, @RequestParam String nom, @RequestParam String prenom, @RequestParam String username, @RequestParam String password, @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam Date date) {
		
		Sopramon mySopramon = new Sopramon();
		
		mySopramon.setDate(date);
		mySopramon.setPseudo(pseudo);
		
		mySopramon.setNom(nom);
		mySopramon.setPrenom(prenom);
		mySopramon.setUsername(username);
		mySopramon.setPassword(password);
		mySopramon.setExperience(0);
		mySopramon.setNiveau(1);
		mySopramon.setArgent(500);
		
		
		daoSopramon.save(mySopramon);
		
		return "redirect:/Connexion";
	}
	
	

}