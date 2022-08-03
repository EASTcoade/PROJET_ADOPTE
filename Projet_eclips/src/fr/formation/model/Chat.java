package fr.formation.model;

import java.util.Date;
import java.util.List;

public class Chat {
	protected String texte;
	protected Utilisateur destinataire;
	protected Utilisateur expediteur;
	protected Date dateEnvoi;
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Utilisateur getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}
	public Utilisateur getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	
	public String envoyerMessage(Utilisateur expe, Utilisateur desti, String contenu) {
		return contenu;
	}
	public String recevoirMessage(Utilisateur expe, Utilisateur desti, String contenu) {
		return contenu;
	}
	public String envoyerMessagePublique(Utilisateur expe, List<Utilisateur> listDesti, String contenu) {
		return contenu;
	}
		
}
