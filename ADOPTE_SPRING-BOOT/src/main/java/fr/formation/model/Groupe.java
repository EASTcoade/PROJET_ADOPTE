package fr.formation.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity //Annotation obligatoire sur la classe persisté
@Table (name = "groupe") // Optionnel, précise le nom de la table
public class Groupe {
	@Id //anotation obligatoire sur l'id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //auto increment
	@Column (name= "gro_id", nullable = false)
	protected int id;
	
	@Column(name="gro_nom", length=50,nullable=false)
	protected String nom;
	
	@ManyToMany
	@JoinTable (name= "groupe_leader",
	joinColumns=@JoinColumn(name="leagrp_groupe_id"),
	inverseJoinColumns=@JoinColumn(name="leagrp_leader_id"))
	protected List<Leader> leaders ;
	
	
	@ManyToMany
	@JoinTable (name= "utilisateur_groupe",
	joinColumns=@JoinColumn(name="utigrp_groupe_id"),
	inverseJoinColumns=@JoinColumn(name="utigrp_utilisateur_id"))
	protected List<Utilisateur> membres ;
	

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Leader> getLeaders() {
		return this.leaders;
	}
	public void setLeaders(List<Leader> leaders) {
		this.leaders = leaders;
	}
	public List<Utilisateur> getMembres() {
		return membres;
	}
	public void setMembres(ArrayList<Utilisateur> groupe) {
		this.membres = groupe;
	}
	
	public void ajouterGroupe(Utilisateur chef, ArrayList<Utilisateur> amis ){
		
		for (Utilisateur people : amis)
		{
			if (people.friendWith(people, chef))
			{
				this.membres.add(people);
			}
		}
		
	}
}
