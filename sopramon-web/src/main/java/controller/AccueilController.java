package controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccueilController {
	@GetMapping(value="/Accueil")
	public String home(@RequestParam(defaultValue="there") String username, Model model) {
		model.addAttribute("utilisateur", username);
		return "Accueil";
	}


}
