package fr.formation.service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.model.Notification;

import fr.formation.repo.INotificationRepository;
import fr.formation.repo.IUtilisateurRepository;
import fr.formation.repo.sql.NotificationRepositorySql;
import fr.formation.repo.sql.UtilisateurRepositorySql;

public class NotificationService {
	private INotificationRepository repoNotification = new NotificationRepositorySql();
	
	
	public Notification notificationById(String message, Integer id) throws IdNegativeException, ItemNotFoundException {
		
	
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		this.repoNotification.notificationById(message, id);
		
		if (message == null) {
			throw new ItemNotFoundException();
		}
		
		
	}
	
	
	
	
}
