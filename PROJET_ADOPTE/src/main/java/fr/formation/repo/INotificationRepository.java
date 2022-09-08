package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Integer> {

}
