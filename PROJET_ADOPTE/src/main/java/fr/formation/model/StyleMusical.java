package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="stylemusical")
public class StyleMusical {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sty_id")
	@JsonView(JsonViews.Common.class)
	private int id;
	
	@Column(name="sty_nom")
	@NotBlank
	@JsonView(JsonViews.Common.class)
	protected String nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
	


