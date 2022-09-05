package fr.formation.repo;


import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.Notification;
import fr.formation.repo.jpa.NotificationRepositoryJpa;

public class NotificationRepositoryTest {
	
	private NotificationRepositoryJpa notifRepo = new NotificationRepositoryJpa();
	
		
	@Test
	public void testFindAll() {
		
		List<Notification> notifications = this.notifRepo.findAll();
		Assertions.assertNotNull(notifications);
		Assertions.assertTrue(notifications.size() > 0);
	}
	
	
	@Test
	public void testFindById() {
		Notification notif = this.notifRepo.findById(1);
		Assertions.assertNotNull(notif);
		Assertions.assertEquals(1, notif.getId());
	}
	
	@Test
	public void testDeleteById() {
		this.notifRepo.deleteById(1);
		Assertions.assertNull(this.notifRepo.findById(1));
		
		
	}
}



