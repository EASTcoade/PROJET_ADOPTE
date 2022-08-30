package fr.formation.model;

public class Image {
	protected FormatImage format;
	protected String titre;
	protected byte [] contenu;
	protected int id;
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
	public FormatImage getFormat() {
		return format;
	}
	public void setFormat(FormatImage format) {
		this.format = format;
	}
	
	public void Modifier() {
		
	}
	
}
