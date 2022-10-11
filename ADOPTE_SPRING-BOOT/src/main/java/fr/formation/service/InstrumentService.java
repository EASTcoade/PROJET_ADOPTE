package fr.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Instrument;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IInstrumentRepository;

@Service
public class InstrumentService {
	@Autowired
	private IInstrumentRepository repoInstrument;

	public void save(Instrument instrument) throws NotValidException {
		if (instrument.getNom() == null || instrument.getNom().isBlank()) {
			throw new NotValidException();
		}

		repoInstrument.save(instrument);
	}

	public Instrument findById(int id) throws IdNegativeException, ItemNotFoundException {
		if (id <= 0) {
			throw new IdNegativeException();
		}

		Instrument monInstrument = repoInstrument.findById(id).get();
		if (monInstrument == null) {
			throw new ItemNotFoundException();
		}
		return monInstrument;
	}
	
	public void deleteById(int id) throws IdNegativeException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		this.repoInstrument.deleteById(id);
	}
	
	public List<Instrument> findAll() {
		List<Instrument> liste = repoInstrument.findAll();
	
		if (liste == null) {
			return new ArrayList<>();
		}
	
		return liste;
	}
	public List<Instrument> findAllFetchJoueurs(){
		List<Instrument> liste = this.repoInstrument.findAllFetchJoueurs();		
		if (liste == null) {
			return new ArrayList<>();
		}	
		return liste;
	}
	public List<Utilisateur> findAllUtilisateurByInstrument(Integer id) throws IdNegativeException, ItemNotFoundException{
		System.out.println("ça passe");
		Instrument ins = this.findById(id);
		
		List<Utilisateur> liste = this.repoInstrument.findAllUtilisateurByInstrument(ins);
		if (liste == null) {
			return new ArrayList<>();
		}	
		return liste;
	}
	
}