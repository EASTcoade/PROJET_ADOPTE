package fr.formation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Notification {
	private String message;
	private LocalDateTime date;
	private List<Utilisateur> destinataire = new ArrayList<>() ;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public List<Utilisateur> getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(List<Utilisateur> destinataire) {
		this.destinataire = destinataire;
	}
	
	public void notification () {
		
}
}