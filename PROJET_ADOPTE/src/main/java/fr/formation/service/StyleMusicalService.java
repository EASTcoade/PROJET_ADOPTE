package fr.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.StyleMusical;
import fr.formation.repo.IStyleMusicalRepository;

@Service
public class StyleMusicalService {
	@Autowired
	private IStyleMusicalRepository repoStyleMusical;

	public void save(StyleMusical styleMusical) throws NotValidException {
		if (styleMusical.getNom() == null || styleMusical.getNom().isBlank()) {
			throw new NotValidException();
		}

		repoStyleMusical.save(styleMusical);
	}

	public Optional<StyleMusical> findById(int id) throws IdNegativeException, ItemNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}

		Optional<StyleMusical> monStyleMusical = repoStyleMusical.findById(id);
		if (monStyleMusical == null) {
			throw new ItemNotFoundException();
		}
		return monStyleMusical;
	}
	
	public void deleteById(int id) throws IdNegativeException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		this.repoStyleMusical.deleteById(id);
	}
	
	public List<StyleMusical> findAll() {
		List<StyleMusical> stylesMusicaux = this.repoStyleMusical.findAll();
	
		if (stylesMusicaux == null) {
			return new ArrayList<>();
		}
	
		return stylesMusicaux;
	}
}