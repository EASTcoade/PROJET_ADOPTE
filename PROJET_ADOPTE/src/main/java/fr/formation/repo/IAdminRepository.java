package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
