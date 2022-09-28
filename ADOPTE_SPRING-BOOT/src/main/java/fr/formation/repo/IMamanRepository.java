package fr.formation.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

	
import fr.formation.model.Maman;

	public interface IMamanRepository  extends JpaRepository<Maman, Integer>{
		Optional<Maman> findByUsername(String username);
	}


