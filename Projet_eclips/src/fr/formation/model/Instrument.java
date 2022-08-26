package fr.formation.model;

public class Instrument {
	protected Image image;
	protected String nom;
	protected int id;
	
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
