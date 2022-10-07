package fr.formation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.repo.IAdminRepository;
import fr.formation.repo.IUtilisateurRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService{

	private static Logger LOGGER=LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Autowired
	private IAdminRepository repoAdmin;
	
	@Autowired
	private IUtilisateurRepository repoUtilisateur;

	
	CustomUserDetailsService(){
		LOGGER.info("create");
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOGGER.info("service:"+username);
		if(repoUtilisateur.findByUsername(username).isPresent()) {
			
			
			return repoUtilisateur.findByUsername(username).get();
		}else {
			if(repoAdmin.findByUsername(username).isPresent()) {
				return repoAdmin.findByUsername(username).get();
			}else {
				throw new UsernameNotFoundException("pas trouvé");
			}			
		}
	}
}
