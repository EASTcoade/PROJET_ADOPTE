package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@Table (name="instrument")
public class Instrument {
	
	@ManyToOne
	@JoinColumn(name="ins_image_id",nullable=false)
//	@Column(name = "ins_image",nullable=false)

	@JsonView(JsonViews.Common.class)
	protected Image image;
	
	@Column(name = "ins_nom",nullable=false)
	@JsonView(JsonViews.Common.class)
	protected String nom;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ins_id")
	@JsonView(JsonViews.Common.class)
	protected int id;
	
	@ManyToMany(mappedBy = "listeinstrument")
	@JsonView(JsonViews.Instrument.class)
	protected List<Utilisateur> listeJoueurs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Image getImage() {
	return image;
	}
	public void setImage(Image image) {
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
