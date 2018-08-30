package sopramon.DAO;

import sopramon.IDAO.IDAO;
import sopramon.model.Sopramon;

public interface IDAOSopramon extends IDAO<Sopramon>{

	public Sopramon findByUtilisateur(String username, String password);

}