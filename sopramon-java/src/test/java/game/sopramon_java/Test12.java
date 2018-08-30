package game.sopramon_java;

import config.AppConfig;


import sopramon.IDAO.IDAOUtilisateur;
import sopramon.model.Sopramon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = { AppConfig.class })

public class Test12 {

	@Autowired(required = false)
	private IDAOUtilisateur daoutilisateur;

	@PersistenceContext
	private EntityManager em;

	
	@Transactional
	@Rollback(true)
	
	@Test

	public void testConnexionUserExistant() {

		String u = "MORIN";
		String p = "MORINLUCILE";
		Sopramon s = (Sopramon) daoutilisateur.findByUsernameAndPassword(u, p);

		assertTrue(daoutilisateur.findById(1).isPresent());
		assertNotNull(daoutilisateur.findById(1).get());
		
		
	}

	
/*	public void testConnexionUserNonExistant() {

		String u = "LAMBERT";
		String p = "LAMBERTGERARD";
		Sopramon s = (Sopramon) daoutilisateur.findByUsernameAndPassword(u, p);

		assertTrue(daoutilisateur.findById(1).isPresent());
		assertNotNull(daoutilisateur.findById(1).get());
	}
*/
}
