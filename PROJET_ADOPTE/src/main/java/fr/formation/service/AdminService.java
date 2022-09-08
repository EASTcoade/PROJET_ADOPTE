package fr.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.UtilisateurNotFoundException;
import fr.formation.model.Admin;
import fr.formation.repo.IAdminRepository;


@Service
public class AdminService {
	
	@Autowired
	private IAdminRepository repoAdmin;
	
	
	public List<Admin> findAll() {
		List<Admin> admins = repoAdmin.findAll();
		
		if (admins == null) {
			return new ArrayList<>();
		}
		
		return admins;
	}
	
	public Optional<Admin> findById(int id) throws IdNegativeException, UtilisateurNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Optional<Admin> admin = repoAdmin.findById(id);
		
		if (admin == null) {
			throw new UtilisateurNotFoundException();
		}
		
		return admin;
	}
	
	public void save(Admin admin) throws NotValidException {
		if (admin.getNom() == null || admin.getNom().isBlank()) {
			throw new NotValidException();
		}
		if (admin.getPassword() == null || admin.getPassword().isBlank()) {
			throw new NotValidException();
		}		
		repoAdmin.save(admin);
	}
	
	
	public void deleteById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		repoAdmin.deleteById(id);
	}
	
	public void findByNom(String nom) throws NotValidException{
		
		if (nom == null || nom.isBlank()) {
			throw new NotValidException();
		}
	}
	
}

