package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="son")
public class Son{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="son_id")
	protected int id;
	
	@ManyToOne
	@JoinColumn(name="son_uti_id")
	protected Utilisateur createur;
	
	@Column(name="son_nom",nullable=false,length=50)
	protected String titre;
	
	@Column(name="son_contenu")
	protected byte[] contenu;
	
	@Column(name="son_format",nullable=false)
	@Enumerated(EnumType.STRING)
	protected FormatSon format;
	
	public FormatSon getFormat() {
		return format;
	}
	public void setFormat(FormatSon format) {
		this.format = format;
	}
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
