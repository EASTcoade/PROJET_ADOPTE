package fr.formation.service;

import java.util.ArrayList;
import java.util.List;


import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.UtilisateurNotFoundException;

import fr.formation.model.Instrument;
import fr.formation.model.Utilisateur;

import fr.formation.repo.IUtilisateurRepository;
import fr.formation.repo.jpa.UtilisateurRepositoryJpa;
import fr.formation.repo.sql.UtilisateurRepositorySql;



public class UtilisateurService {
	private IUtilisateurRepository repoUtilisateur = new UtilisateurRepositoryJpa();
	
	
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateur = repoUtilisateur.findAll();
		
		if (utilisateur == null) {
			return new ArrayList<>();
		}
		
		return utilisateur;
	}
	
	public Utilisateur findById(int id) throws IdNegativeException, UtilisateurNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Utilisateur utilisateur = repoUtilisateur.findById(id);
		
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
	
}

