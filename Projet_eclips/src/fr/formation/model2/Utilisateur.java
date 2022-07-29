package fr.formation.model2;

import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Instrument;

public class Utilisateur {
	private String mdp;
	private String nom;
	private String prenom;
	private String pseudo;
	private String adresse;
	private String mail;
	private String telephone;
	private String photoprofil;
	private int age;
	private List<String> stylemusical;
	private List<Instrument> listeinstrument;
	private String niveau;
	private List<String> son; // à voir avec Jérémy

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhotoprofil() {
		return photoprofil;
	}

	public void setPhotoprofil(String photoprofil) {
		this.photoprofil = photoprofil;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public List<String> getStylemusical() {
		return stylemusical;
	}

	public void setStylemusical(List<String> stylemusical) {
		this.stylemusical = stylemusical;
	}

	public List<Instrument> getListeinstrument() {
		return listeinstrument;
	}

	public void setListeinstrument(List<Instrument> listeinstrument) {
		this.listeinstrument = listeinstrument;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public List<String> getSon() {
		return son;
	}

	public void setSon(List<String> son) {
		this.son = son;
	}

public String inscription () {
	Scanner sc = new Scanner (System.in);
	System.out.println("Veuillez rentrer un nom");
	String nom = sc.toString ();
	return nom;
}
//public String Connexion () {
//	System.out.println("veuillez vous connecter");
//	System.out.println("vous êtes connecté");
//	System.out.println("vous êtes n'êtes pas connecté"); //System.err.println("vous n'êtes pas connecté");?
//}
}
