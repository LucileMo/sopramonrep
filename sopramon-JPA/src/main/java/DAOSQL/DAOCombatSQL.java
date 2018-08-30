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

import sopramon.model.Combat;
import sopramon.model.Sopramon;
import sopramon.DAO.IDAOCombat;
import sopramon.model.Arene;
import sopramon.model.Type;

public class DAOCombatSQL extends DAOSQL implements IDAOCombat{
    
  
    public List<Combat> findAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
			//...
			}
		
		try {
			Statement myStatement = this.getConnection().createStatement();
			
			
			ResultSet myResult = myStatement.executeQuery("SELECT * FROM combat");
			
		    List<Combat> mescombats = new ArrayList<Combat>();
            while (myResult.next()) {
            	
               
            	
            	
                Combat myCombat = new Combat();
                myCombat.setId(myResult.getInt("COMB_ID"));
                myCombat.setDate(myResult.getDate("COMB_DATE"));
                myCombat.setArene(Arene.values()[myResult.getInt("COMB_ARENE") - 1]);
                myCombat.setType(Type.values()[myResult.getInt("COMB_TYPE") - 1]);
                myCombat.setTours(myResult.getInt("COMB_TOUR"));
              //  myCombat.setBoss(myResult.getInt("COMB_BOSS_ID"));
             //   myCombat.setSopramon(myResult.getInt("COMB_SOPRAMON_ID"));
                mescombats.add(myCombat);
            }
            return mescombats;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    


	public Combat findById(int id) {
        // TODO Auto-generated method stub
    
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame", "root",
                    "");
            Statement myStatement = this.getConnection().createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM produit WHERE COMB_ID = " + id);
            Combat Combat = new Combat();
            // Si j'ai un enregistrement
            if (myResult.next()) {
                Combat myCombat = new Combat();
                myCombat.setId(myResult.getInt("COMB_ID"));
                myCombat.setDate(myResult.getDate("COMB_DATE"));
                myCombat.setArene(Arene.values()[myResult.getInt("COMB_ARENE") - 1]);
                myCombat.setType(Type.values()[myResult.getInt("COMB_TYPE") - 1]);
                myCombat.setTours(myResult.getInt("COMB_TOUR"));
              //  myCombat.setBoss(myResult.getInt("COMB_BOSS_ID"));
               // myCombat.setSopramon(myResult.getInt("COMB_SOPRAMON_ID"));
                return myCombat;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Combat save(Combat entity) {
        // TODO Auto-generated method stub
        try {
            // SI LE COMBAT N A PAS D ID C EST UN AJOUT
            // SI LE COMBAT A UN ID ALORS C EST UPDATE
            if (entity.getId() == 0) {
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame",
                        "root", "");
                PreparedStatement myStatement = myConnection.prepareStatement("INSERT INTO combat "
                        + "(COMB_DATE, COMB_ARENE, COMB_TYPE, COMB_TOUR, COMB_BOSS_ID, COMB_SOPRAMON_ID) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    			String dateInString = formatter.format(entity.getDate());
                
                
                myStatement.setString(1, dateInString);
                myStatement.setInt(2, 1);
                myStatement.setInt(3, 3);
                myStatement.setInt(4, 5);
                myStatement.setInt(5, 1);
            //    myStatement.setInt(6, entity.getSopramon());
            
                
                
                myStatement.execute();
            }
            // UPDATE ma_table
            // SET
            // colonne1 = 'valeur 1',
            // colonne2 = 'valeur 2'
            // WHERE colonne = 'valeur';
            else {
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopramongame",
                        "root", "");
                PreparedStatement myStatement = myConnection.prepareStatement(
                        "UPDATE combat SET COMB_ID='5', COMB_DATE=2018, COMB_ARENE='arene1', COMB_TYPE=1, "
                        + "COMB_TOUR=1, COMB_BOSS_ID=1, COMB_SOPRAMON_ID=1 "
                        + "WHERE COMB_ID_PRODUIT=1");
//UPDATE produit SET PRO_NOM='NOUVEAU_PRODUIT', PRO_PRIX=500, PRO_DESCRIPTIF='la_nouvelle_planche' WHERE PRO_ID_PRODUIT=3;
                myStatement.setInt(1, entity.getId());
                myStatement.setString(2, entity.getDate().toString());
                myStatement.setInt(3, 1);
                myStatement.setInt(4, 3);
                myStatement.setInt(5, entity.getTours());
             //   myStatement.setInt(6, entity.getBoss());
         //       myStatement.setInt(7, entity.getSopramon());
                
            
                
                myStatement.execute();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }









	
	public void delete(Combat entity) {
		// TODO Auto-generated method stub
		
	}










	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
}



