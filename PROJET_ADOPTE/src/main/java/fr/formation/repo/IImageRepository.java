package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.reception;

public interface IImageRepository extends JpaRepository <reception, Integer> {

}
