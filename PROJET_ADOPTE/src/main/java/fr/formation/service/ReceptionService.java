package fr.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Reception;
import fr.formation.repo.IReceptionRepository;

@Service
public class ReceptionService {
	@Autowired
	private IReceptionRepository repoReception;

	public void save(Reception reception) throws NotValidException {
		if (reception.getChat() == null) {
			throw new NotValidException();
		}
		if (reception.getDestinataire() == null) {
			throw new NotValidException();
		}

		repoReception.save(reception);
	}

	public Optional<Reception> findById(int id) throws IdNegativeException, ItemNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}

		Optional<Reception> maReception = repoReception.findById(id);
		if (maReception == null) {
			throw new ItemNotFoundException();
		}
		return maReception;
	}
	
	public void deleteById(int id) throws IdNegativeException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		this.repoReception.deleteById(id);
	}
	
	public List<Reception> findAll() {
		List<Reception> receptions = this.repoReception.findAll();
	
		if (receptions == null) {
			return new ArrayList<>();
		}
	
		return receptions;
	}
}