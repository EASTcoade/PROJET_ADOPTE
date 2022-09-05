package fr.formation.service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Instrument;
import fr.formation.repo.IInstrumentRepository;
import fr.formation.repo.jpa.InstrumentRepositoryJpa;


public class InstrumentService {
	private IInstrumentRepository repoInstrument = new InstrumentRepositoryJpa();
	
	public void save(Instrument instrument) throws NotValidException {
		if (instrument.getNom() == null || instrument.getNom().isBlank()) {
			throw new NotValidException();
		}		
		
		repoInstrument.save(instrument);
	}
	public Instrument findById(int id) throws IdNegativeException, ItemNotFoundException {
		if ( id<=0 ) {
			throw new IdNegativeException();
		}
		
	Instrument monInstrument = repoInstrument.findById(id);
		if (monInstrument == null) {
			throw new ItemNotFoundException();
		}
	return monInstrument;
}
}