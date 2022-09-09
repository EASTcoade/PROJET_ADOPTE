package fr.formation.repo;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.AppConfig;
import fr.formation.model.Chat;
import fr.formation.model.FormatSon;
import fr.formation.model.Niveau;
import fr.formation.model.Reception;
import fr.formation.model.Son;
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
		Optional<Chat> chat = this.repoChat.findById(1);
		Assertions.assertNotNull(chat);
		Assertions.assertEquals(1, chat.get().getId());
	}
	@Test
	public void shouldUpdate() {
		Chat chat = this.repoChat.findById(1).get();
		String randomText = UUID.randomUUID().toString();
		
		chat.setTexte(randomText);
		
		
		this.repoChat.save(chat);
		
		chat = this.repoChat.findById(1).get();
		
		Assertions.assertEquals(randomText, chat.getTexte());
	}

	@Test
	public void shouldAdd() {
//		Utilisateur utilisateur = new Utilisateur();
//		String randomName = UUID.randomUUID().toString();
//		
//		utilisateur.setNom(randomName);
//
//		utilisateur.setDateNaissance(LocalDate.now());
//		utilisateur.setPseudo("user1");
//		utilisateur.setPrenom("Alfred");
//		utilisateur.setMail("Alfred@hotmail.fr");
//		utilisateur.setMdp("123");
//		utilisateur.setAdresse("18 rue belleville");
//		utilisateur.setTelephone("0154234515");
//		utilisateur.setNiveau(Niveau.DEBUTANT);
//		
		Reception rec = new Reception();
		ArrayList<Reception> receptions = new ArrayList<>();
		
		Chat chat = generateChat();

		
		rec.setChat(chat);
		rec.setDestinataire(new Utilisateur());
		rec.getDestinataire().setId(1);
		receptions.add(rec);
		
		chat.setDestinataires(receptions);
	
		this.repoChat.save(chat);
		Assertions.assertNotEquals(1, chat.getId());
		Assertions.assertFalse(chat.getDestinataires().get(0).getId()==0);
}
	private static Chat generateChat() {
		Chat chat = new Chat();
		
		genericDataForChat(chat);
		return chat;
	}
	
	private static void genericDataForChat(Chat chat){
		Random r = new Random();
		
		Method[] meths = chat.getClass().getDeclaredMethods();
		
		for(Method m : meths) {
			Class<?>[] types = m.getParameterTypes();
			int countParam=m.getParameterCount();
			
			if(countParam==1 && !m.getName().equals("setId")) {
				try {
					if(types[0].isAssignableFrom(String.class)) {				
						m.invoke(chat,UUID.randomUUID().toString());
					} 
					if(types[0].isAssignableFrom(int.class)||types[0].isAssignableFrom(Integer.class)) {				
						m.invoke(chat,r.nextInt());
					}
					if(types[0].isAssignableFrom(float.class)||types[0].isAssignableFrom(Float.class)) {				
						m.invoke(chat,r.nextInt());
					}
					if(types[0].isAssignableFrom(Utilisateur.class)) {				
						chat.setExpediteur(new Utilisateur());
						chat.getExpediteur().setId(1);
					}

					
				}
				catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void shouldDelete() {
		this.repoChat.deleteById(2);
		Assertions.assertTrue(this.repoChat.findById(2).isEmpty());
		

	}
}
