package fr.formation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//configuration de spring security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// url's
	//filtre definir acces au URL
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		//regle pour controller classique >vue jsp
		http.antMatcher("/**") //urls
				.csrf().disable() //csrf à couper pour webservice
				.authorizeRequests() //definition les regles
					.antMatchers("/","/home").permitAll()//regle pour url / et /home =>tout le monde passe
					.antMatchers("/utilisateur/**").hasAnyRole("ADMIN") //les url fournisseur ne sont accessibles qu'au role ADMIN
					.anyRequest().authenticated() //toute les urls non traitées avant=>authentification
				.and()
				.formLogin();//comment on authentifie les utlisateurs=>formulaire 
				//pas de conf en plus donc formulaire par defaut de spring
		// @formatter:on	
	}

	@Autowired
	private UserDetailsService userDetailsService;
	
	// utilisateurs
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//utilisateurs en memoire
//		// @formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("{noop}admin").roles("ADMIN")
//				.and()
//				.withUser("toto").password("{noop}toto").roles("USER");
//				
//		// @formatter:on
		
		//authentification par un UserDetailsService qu'on doit coder
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
