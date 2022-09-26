package fr.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.UtilisateurNotFoundException;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;


@Service
public class UtilisateurService {
	
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	public Optional<Utilisateur> findByIdFetchSon(int id) throws IdNegativeException, UtilisateurNotFoundException{
		if (id <= 0) {
			throw new IdNegativeException();
		}		
		Optional<Utilisateur> utilisateur = repoUtilisateur.findByIdFetchSon(id);		
		if (utilisateur == null) {
			throw new UtilisateurNotFoundException();
		}		
		return utilisateur;		
	}
	public Optional<Utilisateur> findByIdFetchStyle(int id) throws IdNegativeException, UtilisateurNotFoundException{
		if (id <= 0) {
			throw new IdNegativeException();
		}		
		Optional<Utilisateur> utilisateur = repoUtilisateur.findByIdFetchStyle(id);		
		if (utilisateur == null) {
			throw new UtilisateurNotFoundException();
		}		
		return utilisateur;		
	}
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateur = repoUtilisateur.findAll();
		
		if (utilisateur == null) {
			return new ArrayList<>();
		}
		
		return utilisateur;
	}
	
	public Optional<Utilisateur> findById(int id) throws IdNegativeException, UtilisateurNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Optional<Utilisateur> utilisateur = repoUtilisateur.findById(id);
		
		if (utilisateur == null) {
			throw new UtilisateurNotFoundException();
		}
		
		return utilisateur;
	}
	
	public void save(Utilisateur utilisateur) throws NotValidException {
		if (utilisateur.getNom() == null || utilisateur.getNom().isBlank()) {
			throw new NotValidException();
		}
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isBlank()) {
			throw new NotValidException();
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isBlank()) {
			throw new NotValidException();
		}
		if (utilisateur.getMail() == null || utilisateur.getMail().isBlank()) {
			throw new NotValidException();
		}
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().isBlank()) {
			throw new NotValidException();
		}
		if (utilisateur.getMdp() == null || utilisateur.getMdp().isBlank()) {
			throw new NotValidException();
		}
		if (utilisateur.getAdresse() == null || utilisateur.getAdresse().isBlank()) {
			throw new NotValidException();
		}
		if (utilisateur.getNiveau() == null)  {
			throw new NotValidException();
		}
		
		repoUtilisateur.save(utilisateur);
	}
	
	
	public void deleteById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		repoUtilisateur.deleteById(id);
	}
	
	public void findByNom(String nom) throws NotValidException{
		
		if (nom == null || nom.isBlank()) {
			throw new NotValidException();
		}
	}

	public boolean existsById(Integer id) {
		return repoUtilisateur.existsById(id);
		
	}
	
}

