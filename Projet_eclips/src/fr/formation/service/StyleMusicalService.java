package fr.formation.service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemlNotFoundException;
import fr.formation.model.StyleMusical;
import fr.formation.repo.IStyleMusicalRepository;
import fr.formation.repo.sql.StyleMusicalRepositorySql;

public class StyleMusicalService {
	private IStyleMusicalRepository repoStyleMusical = new StyleMusicalRepositorySql();
	public StyleMusical findById(int id) throws IdNegativeException {
		if (id <= 0) {
			throw new IdNegativeException(); 
		}
		StyleMusical monStyleMusical = repoStyleMusical.findById(id);
		
		if (monStyleMusical == null) {
			throw new ItemlNotFoundException(); 
		}
		return monStyleMusical;
	}
}
