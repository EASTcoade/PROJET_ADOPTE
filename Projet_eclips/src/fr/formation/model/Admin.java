package fr.formation.model;

import java.util.List;

public class Admin {
	protected String password;
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
	

