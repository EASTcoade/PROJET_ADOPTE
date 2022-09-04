package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adm_id")
	private int id;
	
	
	@Column(name = "adm_password", length = 200, nullable = false)
	protected String password;
	@Column(name = "adm_nom", length = 50, nullable = false)
	protected String nom;

	public String getPassword() {
		return password;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void bannir() {
		
	}
	public void annoncer(String x) {
		Notification notif = new Notification() ;
		notif.setMessage(x);
		System.out.println(notif.getMessage());
	}


	public void supprimerutilisateur(Utilisateur utilisateur, List<Utilisateur> userlist) {
		
				userlist.remove(utilisateur);
			
		}
	}
	

