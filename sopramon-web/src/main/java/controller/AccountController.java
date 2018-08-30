package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	
	
	@GetMapping(value="/Connexion")
	public String login(@RequestParam(defaultValue="there") String username, Model model) {
		model.addAttribute("utilisateur", username);
		return "Connexion";
	}

	@GetMapping(value="/Inscription")
	public String create(@RequestParam(defaultValue="there") String username, Model model) {
		model.addAttribute("utilisateur", username);
		return "Inscription";
	}


}