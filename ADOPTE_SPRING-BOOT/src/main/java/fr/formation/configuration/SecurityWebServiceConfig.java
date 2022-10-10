package fr.formation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityWebServiceConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		return http.antMatcher("/api/**")
						.csrf().disable()
				   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				   .and()
				   .authorizeRequests()
				   		.antMatchers(HttpMethod.OPTIONS).permitAll()
				   		.antMatchers(HttpMethod.POST,"/api/utilisateur").permitAll()
//				   		.antMatchers(HttpMethod.GET,"/api/utilisateur/**").permitAll()
		//		   		.antMatchers(HttpMethod.GET).permitAll()
				   		.anyRequest().authenticated()
				   .and()
				   		.httpBasic()
				   .and()
				   .build();
		// @formatter:on

	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
