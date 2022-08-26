package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.StyleMusical;
import fr.formation.repo.IStyleMusicalRepository;
import fr.formation.repo.sql.StyleMusicalRepositorySql;

public class StyleMusicalService {
	private IStyleMusicalRepository repoStyleMusical = new StyleMusicalRepositorySql();
	public StyleMusical findById(int id) throws IdNegativeException, ItemNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException(); 
		}
		StyleMusical monStyleMusical = repoStyleMusical.findById(id);
		
		if (monStyleMusical == null) {
			throw new ItemNotFoundException(); 
		}
		return monStyleMusical;
	}
	
	public List<StyleMusical> findAll() {
		
		List<StyleMusical> styleMusicaux = repoStyleMusical.findAll();
		
		if (styleMusicaux == null) {
			return new ArrayList<>();
		}
		
		return styleMusicaux;
		
		
	}
	
	public void deleteById(int id) throws IdNegativeException{
	if (id <=0) {
		throw new IdNegativeException();
	}
	repoStyleMusical.deleteById(id);
	}
	
	public void save(StyleMusical monStyleMusical) throws NotValidException {
		if (monStyleMusical.getNom() == null || monStyleMusical.getNom().isBlank()) {
			throw new NotValidException();
		}
		repoStyleMusical.save(monStyleMusical);
		
	}
}
