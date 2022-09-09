package fr.formation.repo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.formation.config.AppConfig;
import fr.formation.model.Chat;
import fr.formation.model.Niveau;
import fr.formation.model.Reception;
import fr.formation.model.Utilisateur;



@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
@Sql(scripts = "classpath:/data.sql")
public class ChatRepositoryTest {

	@Autowired
	private IChatRepository repoChat ;
	
	
	@Test
	public void testFindAll() {
		
		List<Chat> messages = this.repoChat.findAll();
		Assertions.assertNotNull(messages);
		Assertions.assertTrue(messages.size() > 0);
	}
	
	
	@Test
	public void findAllById() {
		
		Integer ids[] = {1};

		Iterable<Integer> iterable = Arrays.asList(ids);
		
		Optional<List<Chat>> messages = Optional.ofNullable(this.repoChat.findAllById(iterable));

		Assertions.assertNotNull(messages);
		System.out.println(messages);
		Assertions.assertTrue(messages.isPresent());
	}
	
	@Test
	public void testFindById() {
		Optional<Chat> chat = this.repoChat.findById(10);
		Assertions.assertNotNull(chat);
		Assertions.assertEquals(10, chat.get().getId());
	}
	
	@Test
	public void shouldAdd() {
		Utilisateur utilisateur = new Utilisateur();
		String randomName = UUID.randomUUID().toString();
		
		utilisateur.setNom(randomName);
		utilisateur.setId(10);
		utilisateur.setDateNaissance(LocalDate.now());
		utilisateur.setPseudo("user1");
		utilisateur.setPrenom("Alfred");
		utilisateur.setMail("Alfred@hotmail.fr");
		utilisateur.setMdp("123");
		utilisateur.setAdresse("18 rue belleville");
		utilisateur.setTelephone("0154234515");
		utilisateur.setNiveau(Niveau.DEBUTANT);
		
		Reception rec = new Reception();
		ArrayList<Reception> receptions = new ArrayList<>();
		
		Chat chat = new Chat();
		chat.setExpediteur(utilisateur);
		
		rec.setChat(chat);
		rec.setDestinataire(utilisateur);
		receptions.add(rec);
		
		chat.setDestinataires(receptions);
	

		Assertions.assertNotEquals(1, chat.getId());
		
}
	
	public void shouldDelete() {
		this.repoChat.deleteById(1);
		Assertions.assertNull(this.repoChat.findById(1));

	}
}
