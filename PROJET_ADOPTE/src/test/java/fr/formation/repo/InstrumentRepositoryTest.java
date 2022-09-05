package fr.formation.repo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.Instrument;
import fr.formation.repo.jpa.InstrumentRepositoryJpa;

public class InstrumentRepositoryTest {
	private InstrumentRepositoryJpa repoInstrument = new InstrumentRepositoryJpa();

	@Test
	public void testFindAll() {
		List<Instrument> Instruments = this.repoInstrument.findAll();
		
		Assertions.assertNotNull(Instruments);
		Assertions.assertTrue(Instruments.size()>0);
	}
	
	@Test
	public void testFindById() {
		Instrument instrument = this.repoInstrument.findById(1);
		
		Assertions.assertNotNull(instrument);
		Assertions.assertTrue(instrument.getId()==1);
	}
	//tester image instrument
}
