package fr.formation.repo.jpa;

import fr.formation.model.Image;
import fr.formation.repo.IImageRepository;

public class ImageRepositoryJpa extends AbstractRepositoryJpa<Image> implements IImageRepository{
	public ImageRepositoryJpa() {
		super(Image.class);
}
}
