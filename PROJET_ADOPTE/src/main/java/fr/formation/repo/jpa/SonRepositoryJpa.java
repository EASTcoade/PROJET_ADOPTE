package fr.formation.repo.jpa;

import fr.formation.model.Son;
import fr.formation.repo.ISonRepository;

public class SonRepositoryJpa extends AbstractRepositoryJpa<Son> implements ISonRepository{

	public SonRepositoryJpa() {
		super(Son.class);
	}

}
