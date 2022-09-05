package fr.formation.repo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.Image;
import fr.formation.repo.jpa.ImageRepositoryJpa;
import fr.formation.repo.jpa.SonRepositoryJpa;

public class ImageRepositoryTest {
	private ImageRepositoryJpa repoImage = new ImageRepositoryJpa();

	@Test
	public void testFindAll() {
		List<Image> Images = this.repoImage.findAll();
		
		Assertions.assertNotNull(Images);
		Assertions.assertTrue(Images.size()>0);
	}
	
	@Test
	public void testFindById() {
		Image image = this.repoImage.findById(1);
		
		Assertions.assertNotNull(image);
		Assertions.assertTrue(image.getId()==1);
	}
}
