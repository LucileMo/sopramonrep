package sopramon.principal;

import java.util.Date;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.DAOSopramonSQL;
import DAO.IDAOSopramon;
import DAO.DAOCombatSQL;
import DAO.IDAOCombat;

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
		}

		catch (Exception ex) {
			return null;
		}
	}

	public static void main(String[] args) {
		int m = 0;
		while (m < 1 || m > 3) {
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

			switch (m) {
			case 1:
				System.out.println("Liste des Sopramons : ");

				for (Sopramon p : daoSopramon.findAll()) {
					System.out.println(p.getNom());
					System.out.println(p.getCapacite().getPointsDeVie() + " points de vie.");
					System.out.println(p.getSigne().getNom());
					System.out.println(p.getUtilisateur());
					System.out.println("-----------------------------");
					System.out.println("(-_-)");
				}

				break;
			case 2:
				System.out.println("Creer un compte");

				System.out.println("Nom : ");
				String n = lireChaine();
				System.out.println("Prenom : ");
				lireChaine();
				System.out.println("Nom de joueur : ");
				lireChaine();
				System.out.println("Mot de passe : ");
				lireChaine();
				System.out.println("Date de Naissance : ");
				String d = lireChaine();
				System.out.println("Signe Astrologique : ");
				lireChaine();

				System.out
						.println("Félicitations votre compte est créé ! Donnez maintenant un nom à votre Sopramon : ");
				lireChaine();
				System.out.println("Félicitations votre Sopramon est né !");

				// IDAOSopramon daoSopramon = new DAOSopramonSQL();

				try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = formatter.parse(d);

					Sopramon nouveauSopramon = new Sopramon();

					nouveauSopramon.setNom(n);
					nouveauSopramon.setDateNaissance(date);

					daoSopramon.save(nouveauSopramon);
				}

				catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Combat contre le boss !");

				System.out.println("Liste des Sopramons : ");

				for (Sopramon p : daoSopramon.findAll()) {
					System.out.println(p.getNom());
					System.out.println(p.getCapacite().getPointsDeVie() + " points de vie.");
					System.out.println(p.getSigne().getNom());
					System.out.println(p.getUtilisateur());
					System.out.println("-----------------------------");
					System.out.println("(^_^)");
					System.out.println("-----------------------------");
				}

				System.out.println("Saisir l'id du Sopramon : ");
				int id = lireEntier();

				System.out.println("Saisir la date du jour : ");
				String dj = lireChaine();

				System.out.println("Félicitations votre combat est créé ! ");

				try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = formatter.parse(dj);

					Combat nouveauCombat = new Combat();

					nouveauCombat.setSopramon(id);
					nouveauCombat.setDate(date);

					daoCombat.save(nouveauCombat);
				}

				catch (Exception e) {
					e.printStackTrace();
				}

				break;

			}

		}

	}

}