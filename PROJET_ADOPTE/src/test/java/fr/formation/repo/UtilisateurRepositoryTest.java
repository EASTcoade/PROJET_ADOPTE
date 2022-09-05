package fr.formation.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.formation.model.Image;
import fr.formation.model.Niveau;

import fr.formation.model.Son;
import fr.formation.model.Utilisateur;

import fr.formation.repo.jpa.UtilisateurRepositoryJpa;

public class UtilisateurRepositoryTest {
	private UtilisateurRepositoryJpa repoUtilisateur = new UtilisateurRepositoryJpa() ;
	
	@BeforeAll
	public static void setup() {
		// On ajoute un utilisateur
		UtilisateurRepositoryJpa repoUtilisateur = new UtilisateurRepositoryJpa() ;
		Utilisateur utilisateur = new Utilisateur();
		
		
		
		utilisateur = new Utilisateur();
		utilisateur.setNom(UUID.randomUUID().toString());
		utilisateur.setId(1);
		utilisateur.setDateNaissance(LocalDate.now());
		utilisateur.setPseudo("user1");
		utilisateur.setPrenom("Alfred");
		utilisateur.setMail("Alfred@hotmail.fr");
		utilisateur.setMdp("123");
		utilisateur.setAdresse("18 rue belleville");
		utilisateur.setTelephone("0154234515");
		utilisateur.setNiveau(Niveau.DEBUTANT);
		repoUtilisateur.save(utilisateur);
	}
	
	
	
	
	@Test
	public void testFindAll() {
		List<Utilisateur> utilisateur = this.repoUtilisateur.findAll();
		Assertions.assertNotNull(utilisateur);
		
	}
	@Test
	public void testFindById() {
		Utilisateur utilisateur = this.repoUtilisateur.findById(2);
		
		Assertions.assertNotNull(utilisateur);
		Assertions.assertTrue(utilisateur.getId()==2);
	}
	
	
	@Test
	public void testDeleteById() {
		this.repoUtilisateur.deleteById(2);
		Assertions.assertNull(this.repoUtilisateur.findById(2));
		
		
	}
	@Test
	public void shouldAdd() {
		Utilisateur utilisateur = new Utilisateur();
		String randomName = UUID.randomUUID().toString();
		
		utilisateur.setNom(randomName);
		utilisateur.setId(1);
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
		Utilisateur utilisateur = this.repoUtilisateur.findById(2);
		String randomName = UUID.randomUUID().toString();
		
		utilisateur.setNom(randomName);
		
		
		this.repoUtilisateur.save(utilisateur);
		
		utilisateur = this.repoUtilisateur.findById(2);
		
		Assertions.assertEquals(randomName, utilisateur.getNom());
	}
	
}
