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
import fr.formation.model.Groupe;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class GroupeRepositoryTest {
	@Autowired
	private IGroupeRepository repoGroupe;;
	
//	@AfterAll
//	public static void closeEmf(){
//		AbstractRepositoryJpa.close();
//	}
	
	@Test
	public void testFindAll() {
		List<Groupe> groupes = this.repoGroupe.findAll();
		
		Assertions.assertNotNull(groupes);
		Assertions.assertTrue(groupes.size()>0);
	}
	
	@Test
	public void testFindById() {
		Optional<Groupe> groupe = this.repoGroupe.findById(1);
		
		Assertions.assertNotNull(groupe);
		Assertions.assertTrue(groupe.isPresent());
		Assertions.assertTrue(groupe.get().getId()==1);
	}
	
	@Test
	public void shouldAdd() {
		Groupe groupe = generateGroupe();
		String groNom = groupe.getNom();
		
		Assertions.assertEquals(0, groupe.getId());
		this.repoGroupe.save(groupe);

		Assertions.assertNotEquals(0, groupe.getId());
		
		groupe = this.repoGroupe.findById(groupe.getId()).get();
		Assertions.assertEquals(groNom, groupe.getNom());
	}
	@Test
	public void shouldUpdate() {
		Groupe groupe = this.repoGroupe.findById(1).get();
		String groNom = groupe.getNom();
		
		groupe.setNom(UUID.randomUUID().toString());
		
		this.repoGroupe.save(groupe);
		
		groupe = this.repoGroupe.findById(1).get();
		
		Assertions.assertNotEquals(groNom, groupe.getNom());
	}
	
	@Test
	public void shouldDelete() {
		this.repoGroupe.deleteById(2);
		
		Optional<Groupe> groupe = this.repoGroupe.findById(2);
		
		Assertions.assertNotNull(groupe);
		Assertions.assertTrue(groupe.isEmpty());
		
	}
	
	private static Groupe generateGroupe() {
		Groupe groupe = new Groupe();
		
		genericDataForGroupe(groupe);
		return groupe;
	}
	
	private static void genericDataForGroupe(Groupe groupe){
		Random r = new Random();
		
		Method[] meths = groupe.getClass().getDeclaredMethods();
		
		for(Method m : meths) {
			Class<?>[] types = m.getParameterTypes();
			int countParam=m.getParameterCount();
			
			if(countParam==1 && !m.getName().equals("setId")) {
				try {
					if(types[0].isAssignableFrom(String.class)) {				
						m.invoke(groupe,UUID.randomUUID().toString());
					} 
					if(types[0].isAssignableFrom(int.class)||types[0].isAssignableFrom(Integer.class)) {				
						m.invoke(groupe,r.nextInt());
					}
					if(types[0].isAssignableFrom(float.class)||types[0].isAssignableFrom(Float.class)) {				
						m.invoke(groupe,r.nextInt());
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
