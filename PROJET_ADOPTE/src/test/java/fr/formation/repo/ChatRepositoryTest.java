package fr.formation.repo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.Chat;
import fr.formation.repo.jpa.ChatRepositoryJpa;

public class ChatRepositoryTest {

	private ChatRepositoryJpa repoChat = new ChatRepositoryJpa();
	
	
	@Test
	public void testFindAll() {
		
		List<Chat> messages = this.repoChat.findAll();
		Assertions.assertNotNull(messages);
		Assertions.assertTrue(messages.size() > 0);
	}
	
	
	@Test
	public void findByPseudo() {
		
		Optional<List<Chat>> messages = this.repoChat.findByPseudo(3);

		Assertions.assertNotNull(messages);
		System.out.println(messages);
		Assertions.assertTrue(messages.isPresent());
	}
	
	@Test
	public void testFindById() {
		Chat chat = this.repoChat.findById(10);
		Assertions.assertNotNull(chat);
		Assertions.assertEquals(10, chat.getId());
	}
}
