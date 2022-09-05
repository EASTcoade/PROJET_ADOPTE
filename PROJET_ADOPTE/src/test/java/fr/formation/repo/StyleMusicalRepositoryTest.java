package fr.formation.repo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.formation.model.StyleMusical;
import fr.formation.repo.jpa.AbstractRepositoryJpa;
import fr.formation.repo.jpa.StyleMusicalRepositoryJpa;

public class StyleMusicalRepositoryTest {
	private StyleMusicalRepositoryJpa repoStyleMusical = new StyleMusicalRepositoryJpa(); //créer une variable objet pour pouvoir accéder aux méthodes Sonrepository

	
	@AfterAll
	public static void closeEmf(){
		AbstractRepositoryJpa.close();
	}
	
	@Test
	public void testFindAll() {
		List<StyleMusical> styles = this.repoStyleMusical.findAll();
		
		Assertions.assertNotNull(styles);
		Assertions.assertTrue(styles.size()>0);
	}
	
	@Test
	public void testFindById() {
		StyleMusical style = this.repoStyleMusical.findById(2);
		
		Assertions.assertNotNull(style);
		Assertions.assertTrue(style.getId()==2);
	}
	
	@Test
	public void shouldAdd() {
		StyleMusical style = generateStyleMusical();
		
		Assertions.assertEquals(0, style.getId());
		this.repoStyleMusical.save(style);

		Assertions.assertNotEquals(0, style.getId());
	}
	@Test
	public void shouldUpdate() {
		StyleMusical style = this.repoStyleMusical.findById(2);
		String sonTitre = style.getNom();
		
		style.setNom(UUID.randomUUID().toString());
		
		this.repoStyleMusical.save(style);
		
		style = this.repoStyleMusical.findById(2);
		
		Assertions.assertNotEquals(sonTitre, style.getNom());
	}
	
	@Test
	public void shouldDelete() {
		this.repoStyleMusical.deleteById(10);
		
		Assertions.assertNull(this.repoStyleMusical.findById(10));
	}
	
	private static StyleMusical generateStyleMusical() {
		StyleMusical style = new StyleMusical();
		
		genericDataForSon(style);
		return style;
	}
	
	private static void genericDataForSon(StyleMusical style){
		Random r = new Random();
		
		Method[] meths = style.getClass().getDeclaredMethods();
		
		for(Method m : meths) {
			Class<?>[] types = m.getParameterTypes();
			int countParam=m.getParameterCount();
			
			if(countParam==1 && !m.getName().equals("setId")) {
				try {
					if(types[0].isAssignableFrom(String.class)) {				
						m.invoke(style,UUID.randomUUID().toString());
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
