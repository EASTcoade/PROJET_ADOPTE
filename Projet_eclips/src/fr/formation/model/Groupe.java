package fr.formation.model;

import java.util.ArrayList;

public class Groupe {
	
	protected SuperUtilisateur chef;
	protected ArrayList<Utilisateur> groupe = new ArrayList<Utilisateur>();
	
	public SuperUtilisateur getChef() {
		return chef;
	}
	public void setChef(SuperUtilisateur chef) {
		this.chef = chef;
	}
	public ArrayList<Utilisateur> getGroupe() {
		return groupe;
	}
	public void setGroupe(ArrayList<Utilisateur> groupe) {
		this.groupe = groupe;
	}
	
	public void ajouterGroupe(SuperUtilisateur chef, ArrayList<Utilisateur> amis ){
		
		for (Utilisateur people : amis)
		{
			if (people.friendWith(people, chef)) 
			{
				this.groupe.add(people);
			}
		}

		
	}
}

	
