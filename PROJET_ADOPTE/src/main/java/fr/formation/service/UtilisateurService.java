package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Instrument;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;
import fr.formation.repo.sql.UtilisateurRepositorySql;



public class UtilisateurService {
	private IUtilisateurRepository repoUtilisateur = new UtilisateurRepositorySql();
	
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateurs = repoUtilisateur.findAll();
		
		if (utilisateurs == null) {
			return new ArrayList<>();
		}
		
		return utilisateurs;
	}
	
	public Utilisateur findById(int id) throws IdNegativeException, ItemNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Utilisateur utilisateur = repoUtilisateur.findById(id);
		
		if (utilisateur == null) {
			throw new ItemNotFoundException();
		}
		
		return utilisateur;
	}
	
	public void save(Utilisateur utilisateur) throws NotValidException {
		if (utilisateur.getNom() == null || utilisateur.getNom().isBlank()) {
			throw new NotValidException();
		}
		
		if (utilisateur.getMdp() == null || utilisateur.getMdp().isBlank()) {
			throw new NotValidException();
		}
		
		if (utilisateur.getMail() == null || utilisateur.getMail().isBlank()) {
			throw new NotValidException();
		}
		
		
		
		repoUtilisateur.save(utilisateur);
		for (Instrument instru: utilisateur.getListeinstrument()) {
			
		}
	}
	
	public void deleteById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		repoUtilisateur.deleteById(id);
	}
}


