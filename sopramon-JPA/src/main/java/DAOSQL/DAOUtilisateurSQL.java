package DAOSQL;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sopramon.DAO.IDAOUtilisateur;
import sopramon.model.Capacite;
import sopramon.model.Signe;
import sopramon.model.Sopramon;
import sopramon.model.Type;
import sopramon.model.Utilisateur;

public class DAOUtilisateurSQL extends DAOSQL implements IDAOUtilisateur {

	
	public List<Utilisateur> findAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
			//...
			}
		
		try {
			Statement myStatement = this.getConnection().createStatement();
			
			
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM utilisateur inner join sopramon on UTILI_ID = SOPRA_UTILISATEUR_ID");
			
		    List<Utilisateur> mesUtilisateurs = new ArrayList<Utilisateur>();
			
			
			
			while (myResult.next()) {
				
               
				
                 Capacite myCapacite = new Capacite();
				
				myCapacite.setId(myResult.getInt("CAPA_ID"));
				myCapacite.setPointsDeVie(myResult.getInt("CAPA_PointsDeVie"));
				myCapacite.setAttaque(myResult.getInt("CAPA_attaque"));
				myCapacite.setDefense(myResult.getInt("CAPA_defense"));
				myCapacite.setEsquive(myResult.getInt("CAPA_esquive"));
				myCapacite.setVitesse(myResult.getInt("CAPA_vitesse"));
				
				Signe mySigne = new Signe();
				
				mySigne.setId(myResult.getInt("SIG_ID"));
				mySigne.setNom(myResult.getString("SIG_NOM"));
				mySigne.setTypeNom(myResult.getString("SIG_TYPE_NOM"));
				
			
			Sopramon mysopramon = new Sopramon();
			mysopramon.setId(myResult.getInt("SOPRA_ID"));
			mysopramon.setNom(myResult.getString("SOPRA_NOM"));
			mysopramon.setDateNaissance(myResult.getDate("SOPRA_DATE_NAISSANCE"));
			mysopramon.setExperience(myResult.getInt("SOPRA_EXPERIENCE"));
			mysopramon.setNiveau(myResult.getInt("SOPRA_NIVEAU"));
			mysopramon.setArgent(myResult.getInt("SOPRA_ARGENT"));
			mysopramon.setCapacite(myCapacite);
			mysopramon.setSigne(mySigne);
			
			
			Utilisateur myutilisateur = new Utilisateur();
			myutilisateur.setId(myResult.getInt("UTIL_ID"));
			myutilisateur.setNom(myResult.getString("UTIL_NOM"));
			myutilisateur.setPrenom(myResult.getString("UTIL_PRENOM"));
			myutilisateur.setUsername(myResult.getString("UTIL_USERNAME"));
			myutilisateur.setPassword(myResult.getString("UTIL_PASSWORD"));
		
			
			
			mesUtilisateurs.add(myutilisateur);

			}
			
			return mesUtilisateurs;
		}
		
			catch (SQLException e) {
			//...
			e.printStackTrace();

		
			}
		return null;
	}

	
	public Utilisateur findById(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
			//...
			}
		
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root", "");
			Statement myStatement = myConnection.createStatement();
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM utilisateur WHERE UTIL_ID = 2");
	
			
			if (myResult.next()) {
				
				 Capacite myCapacite = new Capacite();
					
					myCapacite.setId(myResult.getInt("CAPA_ID"));
					myCapacite.setPointsDeVie(myResult.getInt("CAPA_PointsDeVie"));
					myCapacite.setAttaque(myResult.getInt("CAPA_attaque"));
					myCapacite.setDefense(myResult.getInt("CAPA_defense"));
					myCapacite.setEsquive(myResult.getInt("CAPA_esquive"));
					myCapacite.setVitesse(myResult.getInt("CAPA_vitesse"));
					
					Signe mySigne = new Signe();
					
					mySigne.setId(myResult.getInt("SIG_ID"));
					mySigne.setNom(myResult.getString("SIG_NOM"));
					mySigne.setTypeNom(myResult.getString("SIG_TYPE_NOM"));


				
				Sopramon mysopramon = new Sopramon();
				mysopramon.setId(myResult.getInt("SOPRA_ID"));
				mysopramon.setNom(myResult.getString("SOPRA_NOM"));
				mysopramon.setDateNaissance(myResult.getDate("SOPRA_DATE_NAISSANCE"));
				mysopramon.setExperience(myResult.getInt("SOPRA_EXPERIENCE"));
				mysopramon.setNiveau(myResult.getInt("SOPRA_NIVEAU"));
				mysopramon.setArgent(myResult.getInt("SOPRA_ARGENT"));
				mysopramon.setCapacite(myCapacite);
				mysopramon.setSigne(mySigne);

				
				
				Utilisateur myutilisateur = new Utilisateur();
				myutilisateur.setId(myResult.getInt("UTIL_ID"));
				myutilisateur.setNom(myResult.getString("UTIL_NOM"));
				myutilisateur.setPrenom(myResult.getString("UTIL_PRENOM"));
				myutilisateur.setUsername(myResult.getString("UTIL_USERNAME"));
				myutilisateur.setPassword(myResult.getString("UTIL_PASSWORD"));
				return myutilisateur;
			}
			
			
		}
		
			catch (SQLException e) {
			//...
			

		
			}
		return null;
	}

	
	public Utilisateur save(Utilisateur entity) {
		// Si pas Id => ajout
		// sinon avec id => update
		
		if (entity.getId() == 0){
			try {
		
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root", "");
			PreparedStatement myStatement = myConnection.prepareStatement("INSERT INTO utilisateur (UTIL_NOM, UTIL_PRENOM, UTIL_USERNAME, UTIL_PASSWORD) VALUES(?, ?, ?, ?)");
			
			//capacite
			
		/*	myCapacite.setInt(entity.getCapacite().getId());
			myCapacite.setInt(entity.getPointsDeVie());
			myCapacite.setInt(entity.getAttaque());
			myCapacite.setInt(entity.getDefense());
			myCapacite.setInt(entity.getEsquive());
			myCapacite.setInt(entity.getVitesse());*/
			
			
			
			myStatement.setString(1, entity.getNom());
			myStatement.setString(2, entity.getPrenom());
			myStatement.setString(3, entity.getUsername());
			myStatement.setString(4, entity.getPassword());
		


			
			myStatement.executeUpdate();
			
		}
		
			catch (SQLException e) {
			e.printStackTrace();
			

		
			}
		return null;
		}
		
		
		else {
			
		
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root", "");
			PreparedStatement myStatement = myConnection.prepareStatement("UPDATE utilisateur SET UTIL_NOM = ? WHERE UTIL_ID = ?");
			
			
			
			
			myStatement.setString(1, entity.getNom());
			myStatement.setInt(2, entity.getId());
		

			
			myStatement.executeUpdate();
			
		}
		
			catch (SQLException e) {
			e.printStackTrace();
			

		
			}
		return null;
		
	}

	}

	
	public void delete(Utilisateur entity) {
		
		deleteById(entity.getId());
	}


	
	public void deleteById(int id) {
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root", "");
			PreparedStatement myStatement = myConnection.prepareStatement("DELETE from Utilisateur where UTIL_ID =" + id);
			
	
			myStatement.executeUpdate();
			
		}
		
			catch (SQLException e) {
			e.printStackTrace();
			

		
			}
	}



	

	
	
}
