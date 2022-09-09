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
import fr.formation.model.FormatSon;
import fr.formation.model.Son;
import fr.formation.model.Utilisateur;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class SonRepositoryTest {
	@Autowired
	private ISonRepository repoSon; 
	
//	@AfterAll
//	public static void closeEmf(){
//		AbstractRepositoryJpa.close();
//	}
	
	@Test
	public void testFindAll() {
		List<Son> sons = this.repoSon.findAll();
		
		Assertions.assertNotNull(sons);
		Assertions.assertTrue(sons.size()>0);
	}
	
	@Test
	public void testFindById() {
		Optional<Son> son = this.repoSon.findById(1);
		
		Assertions.assertNotNull(son);
		Assertions.assertTrue(son.isPresent());
		Assertions.assertTrue(son.get().getId()==1);
	}
	
	@Test
	public void shouldAdd() {
		Son son = generateSon();
		String sonTitre = son.getTitre();
		
		Assertions.assertEquals(0, son.getId());
		this.repoSon.save(son);

		Assertions.assertNotEquals(0, son.getId());
		
		son = this.repoSon.findById(son.getId()).get();
		Assertions.assertEquals(sonTitre, son.getTitre());
	}
	
	@Test
	public void shouldUpdate() {
		Son son = this.repoSon.findById(1).get();
		String sonTitre = son.getTitre();
		
		son.setTitre(UUID.randomUUID().toString());
		
		this.repoSon.save(son);
		
		son = this.repoSon.findById(1).get();
		
		Assertions.assertNotEquals(sonTitre, son.getTitre());
	}
	
	@Test
	public void shouldDelete() {
		this.repoSon.deleteById(2);
		
		Optional<Son> son = this.repoSon.findById(2);
		
		Assertions.assertNotNull(son);
		Assertions.assertTrue(son.isEmpty());
		
	}
	
	private static Son generateSon() {
		Son son = new Son();
		
		genericDataForSon(son);
		return son;
	}
	
	private static void genericDataForSon(Son son){
		Random r = new Random();
		
		Method[] meths = son.getClass().getDeclaredMethods();
		
		for(Method m : meths) {
			Class<?>[] types = m.getParameterTypes();
			int countParam=m.getParameterCount();
			
			if(countParam==1 && !m.getName().equals("setId")) {
				try {
					if(types[0].isAssignableFrom(String.class)) {				
						m.invoke(son,UUID.randomUUID().toString());
					} 
					if(types[0].isAssignableFrom(int.class)||types[0].isAssignableFrom(Integer.class)) {				
						m.invoke(son,r.nextInt());
					}
					if(types[0].isAssignableFrom(float.class)||types[0].isAssignableFrom(Float.class)) {				
						m.invoke(son,r.nextInt());
					}
					if(types[0].isAssignableFrom(Utilisateur.class)) {				
						son.setCreateur(new Utilisateur());
						son.getCreateur().setId(2);
					}
					if(types[0].isAssignableFrom(FormatSon.class)) {
						m.invoke(son, FormatSon.WAV);
					}
					if(types[0].isAssignableFrom(byte[].class)) {
						String chaine = UUID.randomUUID().toString();
						m.invoke(son,chaine.getBytes());
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
