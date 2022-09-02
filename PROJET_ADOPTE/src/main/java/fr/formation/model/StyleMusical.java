package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "styleMusical")
public class StyleMusical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "style_id")
	private int id;
	
	@Column(name = "style_nom", length = 150, nullable = false)
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
