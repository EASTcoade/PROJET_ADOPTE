package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Instrument;

public interface IInstrumentRepository extends JpaRepository<Instrument,Integer>{

}
