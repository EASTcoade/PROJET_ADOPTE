package fr.formation.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import fr.formation.model.Chat;
import fr.formation.repo.IChatRepository;

public class ChatRepositoryJpa extends AbstractRepositoryJpa<Chat> implements IChatRepository {

	public ChatRepositoryJpa() {
		super(Chat.class);
		// TODO Auto-generated constructor stub
	}

	
	public Optional<List<Chat>> findByPseudo(Integer id) {
		
		EntityManager em = emf.createEntityManager();
			
		try {
			
			return Optional.ofNullable(
			em
			.createQuery("select c from Chat c where c.expediteur.id = ?1", Chat.class)
			.setParameter(1, id)
			.getResultList()
			);
			
			}
		catch(Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
		
	}
	

				
}
	
