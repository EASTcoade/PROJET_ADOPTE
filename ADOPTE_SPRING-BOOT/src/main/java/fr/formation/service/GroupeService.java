package fr.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.UtilisateurNotFoundException;
import fr.formation.model.Groupe;
import fr.formation.repo.IGroupeRepository;


@Service
public class GroupeService {
	
	@Autowired
	private IGroupeRepository repoGroupe;
	
	
	public List<Groupe> findAll() {
		List<Groupe> groupes = repoGroupe.findAll();
		
		if (groupes == null) {
			return new ArrayList<>();
		}
		
		return groupes;
	}
	
	public Optional<Groupe> findById(int id) throws IdNegativeException, UtilisateurNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Optional<Groupe> groupe = repoGroupe.findById(id);
		
		if (groupe == null) {
			throw new UtilisateurNotFoundException();
		}
		
		return groupe;
	}
	
	public void save(Groupe groupe) throws NotValidException {
		if (groupe.getNom() == null || groupe.getNom().isBlank()) {
			throw new NotValidException();
		}
		if (groupe.getLeaders() == null || groupe.getLeaders().size()==0) {
			throw new NotValidException();
		}		
		repoGroupe.save(groupe);
	}
	
	
	public void deleteById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		repoGroupe.deleteById(id);
	}
	
	public void findByNom(String nom) throws NotValidException{
		
		if (nom == null || nom.isBlank()) {
			throw new NotValidException();
		}
	}
	
}

