package fr.formation.repo;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.Son;
import fr.formation.repo.jpa.SonRepositoryJpa;

public class SonRepositoryTest {
	private SonRepositoryJpa repoSon = new SonRepositoryJpa();

	@Test
	public void testFindAll() {
		List<Son> sons = this.repoSon.findAll();
		
		Assertions.assertNotNull(sons);
		Assertions.assertTrue(sons.size()>0);
	}
	
	@Test
	public void testFindById() {
		Son son = this.repoSon.findById(2);
		
		Assertions.assertNotNull(son);
		Assertions.assertTrue(son.getId()==2);
	}
}
