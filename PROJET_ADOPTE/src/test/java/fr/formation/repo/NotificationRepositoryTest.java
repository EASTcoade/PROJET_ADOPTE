package fr.formation.repo;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.Notification;
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
		Notification notif = this.notifRepo.findById(2);
		Assertions.assertNotNull(notif);
		Assertions.assertEquals(2, notif.getId());
	}
	
	@Test
	public void testDeleteById() {
		this.notifRepo.deleteById(3);
		Assertions.assertNull(this.notifRepo.findById(3));	
	}
	@Test
	public void shouldAdd() {
		Notification notification = new Notification();
		String randomName = UUID.randomUUID().toString();
		
		notification.setMessage(randomName);
		
		this.notifRepo.save(notification);

		Assertions.assertNotEquals(0, notification.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Notification notification = this.notifRepo.findById(2);
		String ancien = notification.getMessage();
		String randomName = UUID.randomUUID().toString();
		
		notification.setMessage(randomName);
		
		
		this.notifRepo.save(notification);
		
		notification = this.notifRepo.findById(2);
		
		Assertions.assertNotEquals(ancien, notification.getMessage());
	}
}



