package fr.formation.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.formation.model.Admin;
import fr.formation.model.Niveau;
import fr.formation.model.Utilisateur;
import fr.formation.repo.jpa.AdminRepositoryJpa;
import fr.formation.repo.jpa.UtilisateurRepositoryJpa;

public class AdminRepositoryTest {
	private AdminRepositoryJpa repoAdmin = new AdminRepositoryJpa() ;
	
	@BeforeAll
	public static void setup() {
		// On ajoute un utilisateur
		AdminRepositoryJpa repoAdmin = new AdminRepositoryJpa() ;
		Admin admin = new Admin();

		admin.setNom(UUID.randomUUID().toString());
		admin.setId(1);
		admin.setPassword("lolilol");
		repoAdmin.save(admin);
	}
	
	@Test
	public void testFindAll() {
		List<Admin> admin = this.repoAdmin.findAll();
		Assertions.assertNotNull(admin);
		
	}
	@Test
	public void testFindById() {
		Admin admin = this.repoAdmin.findById(2);
		
		Assertions.assertNotNull(admin);
		Assertions.assertTrue(admin.getId()==2);
	}
	
	
	@Test
	public void testDeleteById() {
		this.repoAdmin.deleteById(2);
		Assertions.assertNull(this.repoAdmin.findById(2));
		
		
	}
	@Test
	public void shouldAdd() {
		Admin admin = new Admin();
		String randomName = UUID.randomUUID().toString();
		
		admin.setNom(UUID.randomUUID().toString());
		admin.setId(2);
		admin.setPassword("ahahaha");
		
		
		
		this.repoAdmin.save(admin);

		Assertions.assertNotEquals(0, admin.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Admin admin = this.repoAdmin.findById(2);
		String randomName = UUID.randomUUID().toString();
		
		admin.setNom(randomName);
		
		
		this.repoAdmin.save(admin);
		
		admin = this.repoAdmin.findById(2);
		
		Assertions.assertEquals(randomName, admin.getNom());
	}
}