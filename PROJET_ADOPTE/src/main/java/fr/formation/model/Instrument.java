package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table (name="instrument")
public class Instrument {
	
	@ManyToOne
	@JoinColumn(name="ins_image_id",nullable=false)
//	@Column(name = "ins_image",nullable=false)
	protected reception image;
	
	@Column(name = "ins_nom",nullable=false)
	protected String nom;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ins_id")
	protected int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public reception getImage() {
	return image;
	}
	public void setImage(reception image) {
		this.image = image;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setUtilisateur(Utilisateur monUtilisateur) {
		// TODO Auto-generated method stub
		
	}
}
