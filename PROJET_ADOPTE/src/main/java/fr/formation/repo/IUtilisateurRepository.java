package fr.formation.repo;

import fr.formation.model.Utilisateur;

public interface IUtilisateurRepository extends IRepository<Utilisateur, Integer>{
	public Utilisateur findByNom(String nom);
	
}
