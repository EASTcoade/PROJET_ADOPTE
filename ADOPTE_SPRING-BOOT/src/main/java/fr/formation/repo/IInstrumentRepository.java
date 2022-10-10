package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Instrument;

public interface IInstrumentRepository extends JpaRepository<Instrument,Integer>{
	
	@Query("SELECT i FROM Instrument i left join fetch i.listeJoueurs")
	public List<Instrument> findAllFetchJoueurs();
}
