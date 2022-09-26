package fr.formation.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.formation.config.AppConfig;
import fr.formation.model.reception;
//import fr.formation.config.AppConfig;
import fr.formation.model.Instrument;

@SpringJUnitConfig(AppConfig.class) // Exécuter ce test avec le contexte de SPRING chargé avec la classe de config AppConfig
@Sql("classpath:/data.sql") // Ce script sera joué AVANT (par défaut) CHAQUE test unitaire
@ActiveProfiles("test") // On dit à SPRING qu'on va tester avec le profile "test"
public class InstrumentRepositoryTest {
@Autowired
private IInstrumentRepository repoInstrument;

	@Test
	public void testFindAll() {
		List<Instrument> Instruments = this.repoInstrument.findAll();
		
		Assertions.assertNotNull(Instruments);
		Assertions.assertTrue(Instruments.size()>0);
	}
	
	@Test
	public void testFindById() {
		Optional<Instrument> instrument = this.repoInstrument.findById(1);
		
		Assertions.assertNotNull(instrument);
		Assertions.assertTrue(instrument.isPresent());
	}
	
	@Test
	public void shouldAdd() {
		Instrument instrument = new Instrument();
		String randomName = UUID.randomUUID().toString();
		
		instrument.setNom(randomName);
		instrument.setImage(new reception());
		instrument.getImage().setId(1);
		
		Assertions.assertEquals(0, instrument.getId());
		
		this.repoInstrument.save(instrument);

		Assertions.assertNotEquals(0, instrument.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Instrument instrument = this.repoInstrument.findById(1).get();
		String randomName = UUID.randomUUID().toString();
		
		instrument.setNom(randomName);
		this.repoInstrument.save(instrument);
		
		instrument = this.repoInstrument.findById(1).get();
		
		Assertions.assertEquals(randomName, instrument.getNom());
	}
	
	@Test
	public void shouldDelete() {
		this.repoInstrument.deleteById(2);
		
		Assertions.assertFalse(this.repoInstrument.findById(2).isPresent());
	}
}
