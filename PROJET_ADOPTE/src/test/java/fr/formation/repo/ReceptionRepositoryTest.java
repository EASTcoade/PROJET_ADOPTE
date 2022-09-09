package fr.formation.repo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.formation.config.AppConfig;
import fr.formation.model.Chat;
import fr.formation.model.Reception;
import fr.formation.model.Utilisateur;


@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
@Sql(scripts = "classpath:/data.sql")

public class ReceptionRepositoryTest {
	@Autowired
	private IReceptionRepository repoReception ;
	

	
	@Test
	public void testFindAll() {
		List<Reception> receptions = this.repoReception.findAll();
		
		Assertions.assertNotNull(receptions);
		Assertions.assertTrue(receptions.size()>0);
	}
	
	@Test
	public void testFindById() {
		Optional<Reception> reception = this.repoReception.findById(1);
		
		Assertions.assertNotNull(reception);
		Assertions.assertTrue(reception.isPresent());
	}
	
	@Test
	public void testFindByIdDest() {
		List<Reception> receptions = this.repoReception.findByIdDest(3);
		
		Assertions.assertNotNull(receptions);
		Assertions.assertTrue(receptions.size()>0);
	}
	
	@Test
	public void shouldAdd() {
		Reception reception = generateReception();
		
		Assertions.assertEquals(0, reception.getId());
		this.repoReception.save(reception);

		Assertions.assertNotEquals(0, reception.getId());
	}
	@Test
	public void shouldUpdate() {
		Reception reception = this.repoReception.findById(1).get();
		Boolean recLu = reception.isLu();
		
		reception.setLu(!recLu);
		
		this.repoReception.save(reception);
		
		reception = this.repoReception.findById(1).get();
		
		Assertions.assertNotEquals(recLu, reception.isLu());
	}
	
	@Test
	public void shouldDelete() {
		this.repoReception.deleteById(1);
		
		Assertions.assertNull(this.repoReception.findById(1));
	}
	
	private static Reception generateReception() {
		Reception reception = new Reception();
		
		genericDataForReception(reception);
		return reception;
	}
	
	private static void genericDataForReception(Reception reception){
		Random r = new Random();
		
		Method[] meths = reception.getClass().getDeclaredMethods();
		
		for(Method m : meths) {
			Class<?>[] types = m.getParameterTypes();
			int countParam=m.getParameterCount();
			
			if(countParam==1 && !m.getName().equals("setId")) {
				try {
					if(types[0].isAssignableFrom(String.class)) {				
						m.invoke(reception,UUID.randomUUID().toString());
					} 
					if(types[0].isAssignableFrom(int.class)||types[0].isAssignableFrom(Integer.class)) {				
						m.invoke(reception,r.nextInt());
					}
					if(types[0].isAssignableFrom(float.class)||types[0].isAssignableFrom(Float.class)) {				
						m.invoke(reception,r.nextInt());
					}
					if(types[0].isAssignableFrom(float.class)||types[0].isAssignableFrom(Float.class)) {				
						m.invoke(reception,r.nextBoolean());
					}
					if(types[0].isAssignableFrom(Utilisateur.class)) {				
						reception.setDestinataire(new Utilisateur());
						reception.getDestinataire().setId(3);
					}
					if(types[0].isAssignableFrom(Chat.class)) {				
						reception.setChat(new Chat());
						reception.getChat().setId(1);
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
}
