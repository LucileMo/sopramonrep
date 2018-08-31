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

import sopramon.IDAO.IDAOCombat;
import sopramon.IDAO.IDAOCoup;
import sopramon.model.Combat;
import sopramon.model.Coup;
import sopramon.model.Sopramon;


@Controller
public class SopramonController {

	
	// LISTER LES SOPRAMON
	

	@Autowired 
	private IDAOCombat daoSopramon;
	
	@GetMapping({ "/Espace-admin" })
	public String listesopramon(Model model) {
	
	 List<Sopramon> mySopramons = new ArrayList<Sopramon>();
	 mySopramons = daoSopramon.findAll();
	 	
	 model.addAttribute("sopramons", daoSopramon.findAll());
	
	return "Espace-admin";
	
	}
	
}

