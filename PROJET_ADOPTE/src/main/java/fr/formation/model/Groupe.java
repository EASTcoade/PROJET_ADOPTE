package fr.formation.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Annotation obligatoire sur la classe persisté
@Table (name = "groupe") // Optionnel, précise le nom de la table
public class Groupe {
	@Id //anotation obligatoire sur l'id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //auto increment
	@Column (name= "GRO_ID", nullable = false) //optionnel, par défault le nom de la colonne est le nom de l'attribut
	protected LEADER leader;
	@Column (name= "GRO_LEADER", nullable = false)
	protected ArrayList<Utilisateur> groupe = new ArrayList<Utilisateur>();
	
	public LEADER getLeader() {
		return leader;
	}
	public void setChef(LEADER leader) {
		this.leader = leader;
	}
	public ArrayList<Utilisateur> getGroupe() {
		return groupe;
	}
	public void setGroupe(ArrayList<Utilisateur> groupe) {
		this.groupe = groupe;
	}
	
	public void ajouterGroupe(LEADER chef, ArrayList<Utilisateur> amis ){
		
		for (Utilisateur people : amis)
		{
			if (people.friendWith(people, chef)) 
			{
				this.groupe.add(people);
			}
		}

		
	}
}

	
