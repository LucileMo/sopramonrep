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

import sopramon.DAO.IDAOSopramon;
import sopramon.model.Capacite;
import sopramon.model.Signe;
import sopramon.model.Sopramon;
import sopramon.model.Type;

public class DAOSopramonSQL extends DAOSQL implements IDAOSopramon {

	
	public List<Sopramon> findAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
			//...
			}
		
		try {
			Statement myStatement = this.getConnection().createStatement();
			
			
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM sopramon inner join capacite on SOPRA_CAPACITE_ID = CAPA_ID inner join signe on SOPRA_SIGNE_ID = SIG_ID");
			
		    List<Sopramon> mesSopramons = new ArrayList<Sopramon>();
			
			
			
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
			mesSopramons.add(mysopramon);

			}
			
			return mesSopramons;
		}
		
			catch (SQLException e) {
			//...
			e.printStackTrace();

		
			}
		return null;
	}

	
	public Sopramon findById(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
			//...
			}
		
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root", "");
			Statement myStatement = myConnection.createStatement();
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM sopramon WHERE SOPRA_ID = 2");
	
			
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
				
				return mysopramon;

			}
			
			
		}
		
			catch (SQLException e) {
			//...
			

		
			}
		return null;
	}

	
	public Sopramon save(Sopramon entity) {
		// Si pas Id => ajout
		// sinon avec id => update
		
		if (entity.getId() == 0){
			try {
		
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root", "");
			PreparedStatement myStatement = myConnection.prepareStatement("INSERT INTO Sopramon (SOPRA_NOM, SOPRA_DATE_NAISSANCE, SOPRA_EXPERIENCE, SOPRA_NIVEAU, SOPRA_ARGENT, SOPRA_CAPACITE_ID, SOPRA_SIGNE_ID) VALUES(?, ?, ?, ?, ?, ?, ?)");
			
			//capacite
			
		/*	myCapacite.setInt(entity.getCapacite().getId());
			myCapacite.setInt(entity.getPointsDeVie());
			myCapacite.setInt(entity.getAttaque());
			myCapacite.setInt(entity.getDefense());
			myCapacite.setInt(entity.getEsquive());
			myCapacite.setInt(entity.getVitesse());*/
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateInString = formatter.format(entity.getDateNaissance());
			
			
			myStatement.setString(1, entity.getNom());
			myStatement.setString(2, dateInString);
			myStatement.setInt(3, 0);
			myStatement.setInt(4, 1);
			myStatement.setDouble(5, 500);
			myStatement.setInt(6, 1);
			myStatement.setInt(7, 7);
			
			


			
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
			PreparedStatement myStatement = myConnection.prepareStatement("UPDATE Sopramon SET SOPRA_NOM = ? WHERE SOPRA_ID = ?");
			
			
			
			
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

	
	public void delete(Sopramon entity) {
		
		deleteById(entity.getId());
	}


	
	public void deleteById(int id) {
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root", "");
			PreparedStatement myStatement = myConnection.prepareStatement("DELETE from Sopramon where SOPRA_ID =" + id);
			
	
			myStatement.executeUpdate();
			
		}
		
			catch (SQLException e) {
			e.printStackTrace();
			

		
			}
	}


	public Sopramon findByUtilisateur(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
