package fr.formation.service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Instrument;
import fr.formation.model.StyleMusical;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IInstrumentRepository;
import fr.formation.repo.IStyleMusicalRepository;
import fr.formation.repo.sql.InstrumentRepositorySql;
import fr.formation.repo.sql.StyleMusicalRepositorySql;

public class InstrumentService {
	private IInstrumentRepository repoInstrument = new InstrumentRepositorySql();
	
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