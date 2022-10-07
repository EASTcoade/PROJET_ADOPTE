package fr.formation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Admin;
import fr.formation.model.Utilisateur;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	public Optional<Utilisateur> findByUsername(String pseudo);
}
