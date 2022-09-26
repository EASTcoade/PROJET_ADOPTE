package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Image;

public interface IImageRepository extends JpaRepository <Image, Integer> {

}
