package fr.formation.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Instrument;

public class Utilisateur {
	private int id;
	private LocalDate dateNaissance;
	private String pseudo;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String adresse;
	private String telephone;
	private Niveau niveau;
	private Image photoprofil;
	private int age;
	private List<StyleMusical> stylemusical;
	private List<Instrument> listeinstrument;
	private List<Son> son; // à voir avec Jérémy

	
	
	
public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Image getPhotoprofil() {
		return photoprofil;
	}

	public void setPhotoprofil(Image photoprofil) {
		this.photoprofil = photoprofil;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<StyleMusical> getStylemusical() {
		return stylemusical;
	}

	public void setStylemusical(List<StyleMusical> stylemusical) {
		this.stylemusical = stylemusical;
	}

	public List<Instrument> getListeinstrument() {
		return listeinstrument;
	}

	public void setListeinstrument(List<Instrument> listeinstrument) {
		this.listeinstrument = listeinstrument;
	}

	public List<Son> getSon() {
		return son;
	}

	public void setSon(List<Son> son) {
		this.son = son;
	}

	public boolean friendWith(Utilisateur people, SuperUtilisateur chef) {
		// TODO Auto-generated method stub
		return false;
	}
}
