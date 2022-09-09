package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Reception;

public interface IReceptionRepository extends JpaRepository<Reception,Integer>{
	//public List<Reception> findByIdDest(Integer id);
}
