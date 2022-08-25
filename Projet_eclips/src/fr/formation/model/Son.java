package fr.formation.model;

public class Son {
	protected int id;
	protected Utilisateur createur;
	protected String titre;
	protected byte[] contenu;
	
	public Utilisateur getCreateur() {
		return createur;
	}
	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getContenu() {
		return contenu;
	}
	public void setContenu(byte[] contenu) {
		this.contenu = contenu;
	}
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public void Play() {
		//this.
	}
	
	public void Pause() {
		//this.
	}
	
	public void Stop() {
		//this.
	}
}
