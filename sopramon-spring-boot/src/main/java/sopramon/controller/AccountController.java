package sopramon.controller;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopramon.dao.IDAOSopramon;
import sopramon.dao.IDAOUtilisateur;
import sopramon.model.Sopramon;


@Controller
public class AccountController {
	

	@GetMapping("/Connexion")
	public String login() {
		
	return "Connexion";
	}
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	@PostMapping("/Connexion")
	public String check(@RequestParam String username, @RequestParam String password, Model model) {
		
	if(daoUtilisateur.findByUsername(username) == null){
		
		model.addAttribute("msgerr","Username ou Password erron�(s)");
        return "redirect:/Connexion";
	}
	
	return "redirect:/Redirection";
	}
	
	
	@Secured({"ROLE_ADMIN, ROLE_USER"})
	@GetMapping({ "/Redirection" })
	public String choix(Model model) {
		model.addAttribute("sopramons", daoSopramon.findAll());
	return "Redirection";
	
	}
	
	
	@GetMapping(value="/Inscription")
	public String inscript() {
		return "Inscription";
	}
	@Autowired
	private IDAOSopramon daoSopramon;
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