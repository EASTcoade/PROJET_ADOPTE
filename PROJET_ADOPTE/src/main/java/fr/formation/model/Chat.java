package fr.formation.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="chat")
public class Chat{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cha_id")
	protected int id;
	
	@Column(name="cha_contenu",length=1000)
	protected String texte;
	
	@ManyToOne
	@JoinColumn(name="cha_uti_id_exp")	
	protected Utilisateur expediteur;
	
	@OneToMany(mappedBy="chat")
	protected List<Reception> destinataires;
	
	@Column(name="cha_date")
	protected LocalDateTime dateEnvoi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Utilisateur getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}

	public LocalDateTime getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(LocalDateTime dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public List<Reception> getDestinataires() {
		return destinataires;
	}

	public void setDestinataires(List<Reception> destinataires) {
		this.destinataires = destinataires;
	}
	
	
	
	
	
		
}
