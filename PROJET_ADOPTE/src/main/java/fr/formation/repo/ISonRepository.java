package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Son;

public interface ISonRepository extends JpaRepository<Son,Integer>{
	
}
