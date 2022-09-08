package fr.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Notification;
import fr.formation.repo.INotificationRepository;

@Service
public class NotificationRepositoryService {
	
	@Autowired
	private INotificationRepository notifRepo;
	
	public Optional<Notification> findById(int id) throws IdNegativeException, ItemNotFoundException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Optional<Notification> notif = this.notifRepo.findById(id);

		if (notif == null) {
			throw new ItemNotFoundException();
		}
		
		return notif;
	}
	
	
	public void save(Notification notif) throws NotValidException {
		if(notif.getMessage()==null) {
			throw new NotValidException();
		}
		if(notif.getDestinataires()==null||notif.getDestinataires().size()==0) {
			throw new NotValidException();
		}
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
