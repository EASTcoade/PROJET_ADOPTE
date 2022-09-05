package fr.formation.repo.jpa;

import fr.formation.model.Notification;
import fr.formation.repo.INotificationRepository;

public class NotificationRepositoryJpa extends AbstractRepositoryJpa<Notification> implements INotificationRepository{

	public NotificationRepositoryJpa() {
		super(Notification.class);
		// TODO Auto-generated constructor stub
	}

}
