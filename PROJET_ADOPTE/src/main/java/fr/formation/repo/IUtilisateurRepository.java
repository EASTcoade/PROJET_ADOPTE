package fr.formation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	@Query("select u from Utilisateur u left join fetch u.son where u.id=:id")
	public Optional<Utilisateur> findByIdFetchSon(@Param("id") int id);
	
}
