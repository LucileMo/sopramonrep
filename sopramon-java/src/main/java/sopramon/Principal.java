package sopramon;

import java.util.Date;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;

import sopramon.model.Arene;
import sopramon.model.Boss;
import sopramon.model.Capacite;
import sopramon.model.Combat;
import sopramon.model.Signe;
import sopramon.model.Sopramon;
import sopramon.model.Type;
import sopramon.model.Utilisateur;
import sopramon.IDAO.IDAOSopramon;
import sopramon.IDAO.IDAOCapacite;
import sopramon.IDAO.IDAOCombat;
import sopramon.IDAO.IDAOSigne;
import sopramon.IDAO.IDAOUtilisateur;

public class Principal {

	static int lireEntier() {

		Scanner myScanner = new Scanner(System.in);

		try {
			return myScanner.nextInt();
		}

		catch (Exception ex) {
			return 0;

		}

	}

	static String lireChaine() {
		Scanner myScanner = new Scanner(System.in);
		try {
			return myScanner.next();
		} catch (Exception ex) {
			return null;
		}
	}

	/*
	 * public void findByUsernameAndPassword() { // IDAOUtilisateur daoUtilisateur =
	 * new DAOUtilisateurHibernate(); // IDAOSopramon daoSopramon = new
	 * DAOSopramonHibernate();
	 * 
	 * System.out.println("Username : "); String u = lireChaine();
	 * System.out.println("Password : "); String p = lireChaine(); Sopramon s =
	 * (Sopramon) daoutilisateur.findByUsernameAndPassword(u, p);
	 * System.out.println("Sopramon : " + s.getPseudo());
	 * 
	 * }
	 */

	@Autowired
	private IDAOSopramon daosopramon;

	@Autowired
	private IDAOUtilisateur daoutilisateur;

	@Autowired
	private IDAOCombat daocombat;
	
	@Autowired
	private IDAOSigne daosigne;
	
	@Autowired
	private IDAOCapacite daocapacite;
	
	public void run(String[] args) {

		System.out.println("Bienvenue dans Sopramongame !");
		System.out.println("Quel est votre nom de joueur et votre mot de passe ? ");

		System.out.println("Username : ");
		String u = lireChaine();
		System.out.println("Password : ");
		String p = lireChaine();
		Sopramon s = (Sopramon) daoutilisateur.findByUsernameAndPassword(u, p);
        
		
		if (s != null) {
			
			int m = 0;
			while (m < 1 || m > 2) {
				System.out.println("Votre sopramon : " + s.getPseudo());

				System.out.println("....................");
				System.out.println("........menu........");
				System.out.println("....................");

				System.out.println("1 : Liste des Sopramons");

				System.out.println("2 : Affronter le Boss");

				System.out.println("Saisir un mode : ");

				m = lireEntier();
//      IDAOSopramon daoSopramon = new DAOSopramonSQL();
//      IDAOCombat daoCombat = new DAOCombatSQL();
//      IDAOUtilisateur daoUtilisateur = new DAOUtilisateurSQL();

				switch (m) {
				case 1:
					System.out.println("Liste des Sopramons : ");

					for (Sopramon p1 : daosopramon.findAll()) {
						System.out.println("Pour " + p1.getPseudo());
						System.out.println(p1.getCapacite().getPointsdevie() + " points de vie.");
						System.out
								.println("Signe : " + p1.getSigne().getNom() + " Type : " + p1.getSigne().getTypeNom());
						System.out.println("-----------------------------");

						/*
						 * private IDAOSopramon daosopramon; daosopramon.findAll();
						 */

					}

					break;
				case 2:
					System.out.println("Combat contre le boss !");

					System.out.println("Selectionner l'identifiant de votre Sopramon : ");
					for (Sopramon p2 : daosopramon.findAll()) {
						System.out.println(p2.getPseudo());
						System.out.println(p2.getCapacite().getPointsdevie() + " points de vie.");
						System.out.println(p2.getSigne().getNom());
						System.out.println("-----------------------------");
					}
					int p2 = lireEntier();

					System.out.println("Indiquer la date du jour : ");
					String j = lireChaine();

					try {
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						Date date = formatter.parse(j);
						
						Sopramon nouveauSopramon = new Sopramon();

						nouveauSopramon.setId(p2);

						
						Boss nouveauBoss = new Boss();

						nouveauBoss.setId(1);

						Combat nouveauCombat = new Combat();

						// nouveauCombat.setSopramon(s);
						nouveauCombat.setArene(Arene.donjon);
						nouveauCombat.setBoss(nouveauBoss);
						nouveauCombat.setDate(date);
						nouveauCombat.setSopramon(nouveauSopramon);
						nouveauCombat.setTours(7);
						nouveauCombat.setType(Type.eau);
						

						daocombat.save(nouveauCombat);
					}

					catch (Exception e) {
						e.printStackTrace();
					}
					break;

				default:
					System.out.println("Veuillez saisir � nouveau : ");
					m = lireEntier();

				}
			}

 		
 		}
	
			
	
	 
		

		else {
			System.out.println("Mauvaise saisie ou compte inexistant. ");
			System.out.println("Creer un compte");

			System.out.println("Nom : ");
			String a = lireChaine();
			System.out.println("Prenom : ");
			String b = lireChaine();
			System.out.println("Nom de joueur : ");
			String c = lireChaine();
			System.out.println("Mot de passe : ");
			String g = lireChaine();
			System.out.println("Date de Naissance : ");

			String d = lireChaine();
			System.out.println("Signe Astrologique : ");
			System.out.println("Taper 1 pour Capricorne, 2 pour Verseau, 3 pour Poissons, 4 pour");
			int f = 0;
			f = lireEntier();
			

			System.out.println("Felicitations votre compte est cree ! Donnez maintenant un pseudo a votre Sopramon : ");
			String n = lireChaine();
			System.out.println("Felicitations votre Sopramon est ne !");

			// IDAOSopramon daoSopramon = new DAOSopramonSQL();

			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = formatter.parse(d);

//				Utilisateur nouveauUtilisateur = new Utilisateur();

//				daoutilisateur.save(nouveauUtilisateur);

				Signe nouveauSigne = new Signe();

				nouveauSigne.setId(f);
				
				Capacite nouveauCapacite = new Capacite();

				nouveauCapacite.setPointsdevie(100);
				nouveauCapacite.setAttaque(20);
				nouveauCapacite.setDefense(20);
				nouveauCapacite.setEsquive(20);
				nouveauCapacite.setVitesse(20);
			
				daocapacite.save(nouveauCapacite);
				
				Sopramon nouveauSopramon = new Sopramon();
				
				nouveauSopramon.setNom(a);
				nouveauSopramon.setPrenom(b);
				nouveauSopramon.setUsername(c);
				nouveauSopramon.setPassword(g);
				
				nouveauSopramon.setPseudo(n);
				nouveauSopramon.setDate(date);
				nouveauSopramon.setExperience(0);
				nouveauSopramon.setNiveau(0);
				nouveauSopramon.setArgent(500);
				nouveauSopramon.setSigne(nouveauSigne);
				nouveauSopramon.setCapacite(nouveauCapacite);
				
				daosopramon.save(nouveauSopramon);

			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}