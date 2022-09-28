package fr.formation.repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.formation.config.AppConfig;
import fr.formation.model.FormatImage;
import fr.formation.model.reception;
import fr.formation.model.Niveau;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IImageRepository;
import fr.formation.repo.ISonRepository;

@SpringJUnitConfig(AppConfig.class) // Exécuter ce test avec le contexte de SPRING chargé avec la classe de config AppConfig
@Sql("classpath:/data.sql") // Ce script sera joué AVANT (par défaut) CHAQUE test unitaire
@ActiveProfiles("test") // On dit à SPRING qu'on va tester avec le profile "test"
public class ImageRepositoryTest {
@Autowired
private IImageRepository repoImage;

	@Test
	public void testFindAll() {
		List<reception> Images = this.repoImage.findAll();
		
		Assertions.assertNotNull(Images);
		Assertions.assertTrue(Images.size()>0);
	}
	
	@Test
	public void testFindById() {
		Optional<reception> image = this.repoImage.findById(2);
		
		Assertions.assertNotNull(image);
		Assertions.assertTrue(image.isPresent());
	}
	@Test
	public void testDeleteById() {
		this.repoImage.deleteById(3);
		Assertions.assertFalse(this.repoImage.findById(3).isPresent());
}
	
	@Test
	public void shouldAdd() {
		reception image = new reception();
	
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
		reception image = this.repoImage.findById(1).get();
		
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
		
		image = this.repoImage.findById(1).get();
		
		Assertions.assertNotEquals(ancien, image.getContenu());
	}

}