package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Leader {
	@Id //anotation obligatoire sur l'id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //auto increment
	@Column (name= "lea_id", nullable = false)
	protected int id;
	
	@ManyToOne
	@JoinColumn(name = "lea_utilisateur_id")
	protected Utilisateur utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
}
