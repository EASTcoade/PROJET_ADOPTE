package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import fr.formation.repo.IMamanRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IMamanRepository mamanRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return mamanRepo.findByUsername(username).orElseThrow(()->{
			throw new UsernameNotFoundException("utilisateur inconnu");
		});
	}
	
	
}
