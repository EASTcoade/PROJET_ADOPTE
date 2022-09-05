package fr.formation.repo.jpa;

import fr.formation.model.Admin;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IAdminRepositoryJpa;


public class AdminRepositoryJpa extends AbstractRepositoryJpa<Admin> implements IAdminRepositoryJpa {
	public AdminRepositoryJpa() {
		super(Admin.class);
		// TODO Auto-generated constructor stub
	}
}