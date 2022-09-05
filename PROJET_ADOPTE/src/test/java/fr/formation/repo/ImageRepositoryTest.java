package fr.formation.repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.FormatImage;
import fr.formation.model.Image;
import fr.formation.model.Niveau;
import fr.formation.model.Utilisateur;
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
		Image image = this.repoImage.findById(2);
		
		Assertions.assertNotNull(image);
		Assertions.assertTrue(image.getId()==2);
	}
	@Test
	public void testDeleteById() {
		this.repoImage.deleteById(1);
		Assertions.assertNull(this.repoImage.findById(1));
}
	
	@Test
	public void shouldAdd() {
		Image image = new Image();
	
		File f = new File("D:\\coding\\guitare.jpg");
	
		byte[] bytesFromFile = null;
		try {
			bytesFromFile = Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		image.setId(1);
		image.setContenu(bytesFromFile);
		image.setTitre("premiere image");
		image.setFormat(FormatImage.JPG);
		
		
		this.repoImage.save(image);

		Assertions.assertNotEquals(0, image.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Image image = this.repoImage.findById(2);
		
		byte[] ancien = image.getContenu();
		
		File f = new File("D:\\coding\\guitare.jpg");
		
		byte[] bytesFromFile = null;
		try {
			bytesFromFile = Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		image.setContenu(bytesFromFile);
		
		
		this.repoImage.save(image);
		
		image = this.repoImage.findById(2);
		
		Assertions.assertNotEquals(ancien, image.getContenu());
	}
	
	
}
