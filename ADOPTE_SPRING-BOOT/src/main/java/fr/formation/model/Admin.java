package fr.formation.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
@Entity
@DiscriminatorValue("admin")
public class Admin extends Maman {

	public void bannir() {
		
	}
	public void annoncer(String x) {
		Notification notif = new Notification() ;
		notif.setMessage(x);
		System.out.println(notif.getMessage());
	}

//faire service admin par la suite?
	public void supprimerutilisateur(Utilisateur utilisateur, List<Utilisateur> userlist) {
		
				userlist.remove(utilisateur);
			
		}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
}
	}
	

