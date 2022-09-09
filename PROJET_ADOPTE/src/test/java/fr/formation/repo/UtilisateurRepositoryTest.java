package fr.formation.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.formation.config.AppConfig;
import fr.formation.model.Image;
import fr.formation.model.Niveau;

import fr.formation.model.Son;
import fr.formation.model.Utilisateur;


@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
@Sql(scripts = "classpath:/data.sql")

public class UtilisateurRepositoryTest {
	@Autowired
	private IUtilisateurRepository repoUtilisateur ;
	

	
	@Test
	public void testFindAll() {
		List<Utilisateur> utilisateur = this.repoUtilisateur.findAll();
		Assertions.assertNotNull(utilisateur);
		
	}
	@Test
	public void testFindById() {
		Optional<Utilisateur> utilisateur = this.repoUtilisateur.findById(1);
		
		Assertions.assertNotNull(utilisateur);
		Assertions.assertTrue(utilisateur.isPresent());
	}
	
	
	@Test
	public void testDeleteById() {
		this.repoUtilisateur.deleteById(2);
		Assertions.assertNotNull(this.repoUtilisateur.findById(2));
		Assertions.assertTrue(this.repoUtilisateur.findById(2).isEmpty());
		
		
	}
	@Test
	public void shouldAdd() {
		Utilisateur utilisateur = new Utilisateur();
		String randomName = UUID.randomUUID().toString();
		
		utilisateur.setNom(randomName);
		
		utilisateur.setDateNaissance(LocalDate.now());
		utilisateur.setPseudo("user1");
		utilisateur.setPrenom("Alfred");
		utilisateur.setMail("Alfred@hotmail.fr");
		utilisateur.setMdp("123");
		utilisateur.setAdresse("18 rue belleville");
		utilisateur.setTelephone("0154234515");
		utilisateur.setNiveau(Niveau.DEBUTANT);
		
		
		
		this.repoUtilisateur.save(utilisateur);

		Assertions.assertNotEquals(0, utilisateur.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Utilisateur utilisateur = this.repoUtilisateur.findById(1).get();
		String randomName = UUID.randomUUID().toString();
		
		utilisateur.setNom(randomName);
		
		
		this.repoUtilisateur.save(utilisateur);
		
		utilisateur = this.repoUtilisateur.findById(1).get();
		
		Assertions.assertEquals(randomName, utilisateur.getNom());
	}
	
}
