package fr.formation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "not_id")
	private int id;
	
	@Column(name = "not_msg",length=1000)
	private String message;
	
	@Column(name="not_date")
	private LocalDateTime date;
	
	@ManyToMany
	@JoinTable (name ="notification_utilisateur",
	joinColumns=@JoinColumn(name="utinot_notification_id"),
	inverseJoinColumns=@JoinColumn(name="utinot_utilisateur_id"))
	private List<Utilisateur> destinataires;
	
	
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
	public List<Utilisateur> getDestinataires() {
		return destinataires;
	}
	public void setDestinataires(List<Utilisateur> destinataire) {
		this.destinataires = destinataire;
	}
	
	public void notification () {
		
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}