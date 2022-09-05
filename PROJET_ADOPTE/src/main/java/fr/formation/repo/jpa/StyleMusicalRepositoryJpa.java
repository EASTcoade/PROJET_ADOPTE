package fr.formation.repo.jpa;

import fr.formation.model.StyleMusical;
import fr.formation.repo.IStyleMusicalRepository;

public class StyleMusicalRepositoryJpa extends AbstractRepositoryJpa<StyleMusical> implements IStyleMusicalRepository{
	public StyleMusicalRepositoryJpa() {
		super(StyleMusical.class);
	}
}
