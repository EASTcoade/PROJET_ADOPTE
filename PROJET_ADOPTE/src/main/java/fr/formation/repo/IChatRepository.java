package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Chat;

public interface IChatRepository extends JpaRepository<Chat, Integer>{

}
