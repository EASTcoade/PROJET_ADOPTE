package fr.formation.repo;

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
import fr.formation.model.Admin;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class AdminRepositoryTest {
	@Autowired
	private IAdminRepository repoAdmin;
	
	@Test
	public void testFindAll() {
		List<Admin> admin = this.repoAdmin.findAll();
		
		Assertions.assertNotNull(admin);
		Assertions.assertTrue(admin.size() > 0);
		
	}
	@Test
	public void testFindById() {
		Optional<Admin> admin = this.repoAdmin.findById(2);
		
		Assertions.assertNotNull(admin);
		Assertions.assertTrue(admin.isPresent());
		Assertions.assertEquals(2, admin.get().getId());
	}
	
	
	@Test
	public void testDeleteById() {
		this.repoAdmin.deleteById(1);
		
		Optional<Admin> admin = this.repoAdmin.findById(1);

		Assertions.assertNotNull(admin);
		Assertions.assertTrue(admin.isEmpty());
		
		
	}
	
	@Test
	public void shouldAdd() {
		Admin admin = generateAdmin();
		String adminNom = admin.getNom();
		
		Assertions.assertEquals(0, admin.getId());
		this.repoAdmin.save(admin);
		Assertions.assertNotEquals(0, admin.getId());
		
		admin = this.repoAdmin.findById(admin.getId()).get();
		Assertions.assertEquals(adminNom, admin.getNom());
	}
	

	@Test
	public void shouldUpdate() {
		Admin admin = this.repoAdmin.findById(1).get();
		String adminNom = admin.getNom();
		
		admin.setNom("Brandnew Nom !");
		
		this.repoAdmin.save(admin);
		
		admin = this.repoAdmin.findById(1).get();
		
		Assertions.assertNotEquals(adminNom, admin.getNom());
	}
	
	private Admin generateAdmin() {
		Admin admin = new Admin();
		
		genericDataForAdmin(admin);
		return admin;
	}

	private void genericDataForAdmin(Admin admin) {
		
		admin.setNom(UUID.randomUUID().toString());
		admin.setPassword(UUID.randomUUID().toString());

	}
}