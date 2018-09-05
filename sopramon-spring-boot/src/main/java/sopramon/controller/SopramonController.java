package sopramon.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sopramon.dao.IDAOSopramon;




@Controller
public class SopramonController {

	
	// LISTER LES SOPRAMON
	

	@Autowired 
	private IDAOSopramon daoSopramon;
	
	@GetMapping({ "/Espace-admin" })
	public String listesopramon(Model model) {
		model.addAttribute("sopramons", daoSopramon.findAll());
	return "Espace-admin";
	
	}
	


	
}

