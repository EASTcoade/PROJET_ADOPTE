package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@Table (name ="image")
public class Image {
	
	@Column(name="ima_format")
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Common.class)
	protected FormatImage format;
	
	@Column(name = "ima_nom",length=50,nullable=false)
	@JsonView(JsonViews.Common.class)
	protected String titre;
	
	@Column(name = "ima_contenu")
	@JsonView(JsonViews.Common.class)
	protected byte [] contenu;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ima_id")
	@JsonView(JsonViews.Common.class)
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
