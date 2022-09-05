package fr.formation.repo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.FormatSon;
import fr.formation.model.Son;
import fr.formation.model.Utilisateur;
import fr.formation.repo.jpa.AbstractRepositoryJpa;
import fr.formation.repo.jpa.SonRepositoryJpa;

public class SonRepositoryTest {
	private SonRepositoryJpa repoSon = new SonRepositoryJpa();

		
	@AfterAll
	public static void closeEmf(){
		AbstractRepositoryJpa.close();
	}
	
	@Test
	public void testFindAll() {
		List<Son> sons = this.repoSon.findAll();
		
		Assertions.assertNotNull(sons);
		Assertions.assertTrue(sons.size()>0);
	}
	
	@Test
	public void testFindById() {
		Son son = this.repoSon.findById(2);
		
		Assertions.assertNotNull(son);
		Assertions.assertTrue(son.getId()==2);
	}
	
	@Test
	public void shouldAdd() {
		Son son = generateSon();
		
		Assertions.assertEquals(0, son.getId());
		this.repoSon.save(son);

		Assertions.assertNotEquals(0, son.getId());
	}
	@Test
	public void shouldUpdate() {
		Son son = this.repoSon.findById(2);
		String sonTitre = son.getTitre();
		
		son.setTitre(UUID.randomUUID().toString());
		
		this.repoSon.save(son);
		
		son = this.repoSon.findById(2);
		
		Assertions.assertNotEquals(sonTitre, son.getTitre());
	}
	
	@Test
	public void shouldDelete() {
		this.repoSon.deleteById(10);
		
		Assertions.assertNull(this.repoSon.findById(10));
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
