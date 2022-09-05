package fr.formation.repo;

import fr.formation.model.StyleMusical;
import fr.formation.repo.jpa.AbstractRepositoryJpa;

public class StyleMusicalRepositoryJPA extends AbstractRepositoryJpa<StyleMusical> implements IStyleMusicalRepository{
	public StyleMusicalRepositoryJPA() {
		super(StyleMusical.class);
	}
}
