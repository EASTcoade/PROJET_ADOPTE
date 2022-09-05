package fr.formation.repo.jpa;

import fr.formation.model.Groupe;
import fr.formation.repo.IGroupeRepository;

public class GroupeRepositoryJpa extends AbstractRepositoryJpa<Groupe> implements IGroupeRepository{

	public GroupeRepositoryJpa() {
		super(Groupe.class);
	}
	
}
