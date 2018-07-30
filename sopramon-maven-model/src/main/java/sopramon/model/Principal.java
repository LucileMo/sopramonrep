package sopramon.model;


import java.util.Date;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.DAOCombatSQL;
import DAO.DAOSopramonSQL;
import DAO.DAOUtilisateurSQL;
import DAO.IDAOCombat;
import DAO.IDAOSopramon;
import DAO.IDAOUtilisateur;

public class Principal {
	
	static int lireEntier() {
		
		Scanner myScanner = new Scanner(System.in);
		
		try {
			return myScanner.nextInt();
		}
		
		catch (Exception ex) {
			return 0;
			
			
		}}
	
	static String lireChaine() {
		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.next();
		}

		catch (Exception ex) {
			return null;
		}
	}
	
	

	public static void main(String[] args) {
		int m = 0;
		while (m<1 || m>3) {
		System.out.println("....................");
		System.out.println("........menu........");
		System.out.println("....................");
		
		System.out.println("1 : Liste des Sopramons");
	
		System.out.println("2 : Creer un compte");
	
		System.out.println("3 : Affronter le Boss");
		;
		System.out.println("Saisir un mode : ");
		
		m = lireEntier();
		IDAOSopramon daoSopramon = new DAOSopramonSQL();
		IDAOCombat daoCombat = new DAOCombatSQL();
		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL();
		
		switch(m){
		case 1 : System.out.println("Liste des Sopramons : ");
		
		
		
		for (Sopramon p : daoSopramon.findAll()) {
			System.out.println("Pour " + p.getNom());
			System.out.println(p.getCapacite().getPointsDeVie() + " points de vie.");
			System.out.println("Signe : "+ p.getSigne().getNom() + " Type : " + p.getSigne().getTypeNom());
			System.out.println("Taper : " + p.getUtilisateur());
			System.out.println("-----------------------------");
		}
		
		break;
		case 2 : System.out.println("Creer un compte");
		
		
		System.out.println("Nom : ");
		String a =lireChaine();
		System.out.println("Prenom : ");
		String b =lireChaine();
		System.out.println("Nom de joueur : ");
		String c =lireChaine();
		System.out.println("Mot de passe : ");
		String g =lireChaine();
		System.out.println("Date de Naissance : ");
		
		String d = lireChaine();
		System.out.println("Signe Astrologique : ");
		String f =lireChaine();
		
		System.out.println("F�licitations votre compte est cr�� ! Donnez maintenant un nom � votre Sopramon : ");
		String n =lireChaine();
		System.out.println("F�licitations votre Sopramon est n� !");

		
		//IDAOSopramon daoSopramon = new DAOSopramonSQL();
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(d);
			
           Utilisateur nouveauUtilisateur = new Utilisateur();
			
			nouveauUtilisateur.setNom(a);
			nouveauUtilisateur.setPrenom(b);
			nouveauUtilisateur.setUsername(c);
			nouveauUtilisateur.setPassword(g);
			
			daoUtilisateur.save(nouveauUtilisateur);
			
			Sopramon nouveauSopramon = new Sopramon();
			
			nouveauSopramon.setNom(n);
			nouveauSopramon.setDateNaissance(date);
		
			daoSopramon.save(nouveauSopramon);
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		  break;
		case 3 : System.out.println("Combat contre le boss !");
		
		System.out.println("S�l�ctionner l'identifiant de votre Sopramon : ");
		for (Sopramon p : daoSopramon.findAll()) {
			System.out.println(p.getNom());
			System.out.println(p.getCapacite().getPointsDeVie() + " points de vie.");
			System.out.println(p.getSigne().getNom());
			System.out.println(p.getUtilisateur());
			System.out.println("-----------------------------");
		}
		int s = lireEntier();
		
		System.out.println("Indiquer la date du jour : ");
		String j = lireChaine();
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(j);
			
			Combat nouveauCombat = new Combat();
			
			nouveauCombat.setSopramon(s);
			nouveauCombat.setDate(date);
		
			daoCombat.save(nouveauCombat);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		break;
		
		default : System.out.println("Veuillez saisir � nouveau : ");
 	    m = lireEntier();
		 
	}
	  
	}
	
	}

	}

