package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.model.Notification;
import fr.formation.repo.jpa.NotificationRepositoryJpa;

public class NotificationRepositoryService {
	
	private NotificationRepositoryJpa notifRepo = new NotificationRepositoryJpa();
	
	public Notification findById(int id) throws IdNegativeException, ItemNotFoundException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Notification notif = this.notifRepo.findById(id);

		if (notif == null) {
			throw new ItemNotFoundException();
		}
		
		return notif;
	}
	
	
	public void save(Notification notif) {
		
		this.notifRepo.save(notif);
	}
	
	
	
	public void deleteById(int id) throws IdNegativeException {
			
		if (id <= 0) {
			throw new IdNegativeException();
		}
		this.notifRepo.deleteById(id);
	}

	

	public List<Notification> findAll() {
		List<Notification> listNotifications = this.notifRepo.findAll();
	
		if (listNotifications == null) {
			return new ArrayList<>();
		}
	
		return listNotifications;
	}
	
	
}
