package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Groupe;

public interface IGroupeRepository extends JpaRepository<Groupe,Integer>{

}
