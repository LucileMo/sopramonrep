package sopramon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sopramon.dao.IDAOUtilisateur;
import sopramon.model.Utilisateur;

@Service
public class AuthService implements UserDetailsService {
		
		@Autowired
		private IDAOUtilisateur daoUtilisateur;

		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur myUtilisateur = this.daoUtilisateur.findByUsername(username);	
		UtilisateurPrincipal myPrincipal = new UtilisateurPrincipal(myUtilisateur); 	
		
		return myPrincipal;
		
		}
		
}