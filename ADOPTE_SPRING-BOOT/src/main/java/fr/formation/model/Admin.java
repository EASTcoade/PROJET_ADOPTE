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

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@Table(name="admin")
public class Admin extends Maman {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adm_id")
	@JsonView(JsonViews.Common.class)
	private int id;
	
	public Admin() {
		
	}
	public Admin(String username, String password) {
		super(username,password);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	

