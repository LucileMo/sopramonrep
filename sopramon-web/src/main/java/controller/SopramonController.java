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

import sopramon.IDAO.IDAOSopramon;
import sopramon.model.Sopramon;



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

