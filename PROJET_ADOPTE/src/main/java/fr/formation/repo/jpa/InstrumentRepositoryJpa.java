package fr.formation.repo.jpa;

import fr.formation.model.Instrument;
import fr.formation.repo.IInstrumentRepository;

public class InstrumentRepositoryJpa extends AbstractRepositoryJpa<Instrument> implements IInstrumentRepository{
	public InstrumentRepositoryJpa() {
		super(Instrument.class);
	//super pour appeler la classe mère une modalité instrument
}
}


