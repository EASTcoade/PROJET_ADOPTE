package fr.formation.model;

import java.util.ArrayList;

public class Groupe {
	
	protected Leader chef;
	protected ArrayList<Utilisateur> groupe = new ArrayList<Utilisateur>();
	
	public Leader getChef() {
		return chef;
	}
	public void setChef(Leader chef) {
		this.chef = chef;
	}
	public ArrayList<Utilisateur> getGroupe() {
		return groupe;
	}
	public void setGroupe(ArrayList<Utilisateur> groupe) {
		this.groupe = groupe;
	}
	
	public void ajouterGroupe(Leader chef, ArrayList<Utilisateur> amis ){
		
		for (Utilisateur people : amis)
		{
			if (people.friendWith(people, chef)) 
			{
				this.groupe.add(people);
			}
		}

		
	}
}

	
