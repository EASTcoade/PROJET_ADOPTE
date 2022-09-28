package fr.formation.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Notification;
import fr.formation.service.NotificationRepositoryService;

@RestController
@RequestMapping("/api/notification")
public class NotificationRestController {

	@Autowired
	private NotificationRepositoryService notifRepo;
	
	
	@GetMapping("")
	public List<Notification> findAll() {
	return this.notifRepo.findAll();
	}
	
	
	public Notification findById(@PathVariable("id") Integer id) throws IdNegativeException, ItemNotFoundException {
		return this.notifRepo.findById(id).get();
	}
	
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Notification create(@Valid @RequestBody Notification notification,BindingResult br) throws NotValidException {
		// pas d'id dans le fournisseur
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		this.notifRepo.save(notification);
		return notification;
	}
	
	
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		try {
			this.notifRepo.deleteById(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	

}
