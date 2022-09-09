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
import fr.formation.model.Notification;


@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
@Sql(scripts = "classpath:/data.sql")
public class NotificationRepositoryTest {
	
	@Autowired
	private INotificationRepository notifRepo ;
	
		
	@Test
	public void testFindAll() {
		
		List<Notification> notifications = this.notifRepo.findAll();
		Assertions.assertNotNull(notifications);
		Assertions.assertTrue(notifications.size() > 0);
	}
	
	
	@Test
	public void testFindById() {
		Optional<Notification> notif = this.notifRepo.findById(1);
		Assertions.assertNotNull(notif);
		Assertions.assertEquals(1, notif.get().getId());
	}
	
	@Test
	public void testDeleteById() {
		this.notifRepo.deleteById(2);
		Assertions.assertFalse(this.notifRepo.findById(2).isPresent());	
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
		Notification notification = this.notifRepo.findById(2).get();
		String ancien = notification.getMessage();
		String randomName = UUID.randomUUID().toString();
		
		notification.setMessage(randomName);
		
		
		this.notifRepo.save(notification);
		
		notification = this.notifRepo.findById(2).get();
		
		Assertions.assertNotEquals(ancien, notification.getMessage());
	}
}



