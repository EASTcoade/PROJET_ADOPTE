package fr.formation.repo;

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
import fr.formation.model.StyleMusical;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class StyleMusicalRepositoryTest {
	@Autowired
	private IStyleMusicalRepository repoStyleMusical; //créer une variable objet pour pouvoir accéder aux méthodes Sonrepository
	
	@Test
	public void testFindAll() {
		List<StyleMusical> styles = this.repoStyleMusical.findAll();
		
		Assertions.assertNotNull(styles);
		Assertions.assertTrue(styles.size() > 0);
	}
	
	@Test
	public void testFindById() {
		Optional<StyleMusical> style = this.repoStyleMusical.findById(2);
		
		Assertions.assertNotNull(style);
		Assertions.assertTrue(style.isPresent());
		Assertions.assertEquals(1, style.get().getId());
	}
	
	@Test
	public void shouldAdd() {
		StyleMusical style = generateStyleMusical();
		String styleNom = style.getNom();
		
		Assertions.assertEquals(0, style.getId());
		this.repoStyleMusical.save(style);

		Assertions.assertNotEquals(0, style.getId());
		
		style = this.repoStyleMusical.findById(style.getId()).get();
		Assertions.assertEquals(styleNom, style.getNom());
	}
	@Test
	public void shouldUpdate() {
		StyleMusical style = this.repoStyleMusical.findById(1).get();
		String sonTitre = style.getNom();
		
//		style.setNom(UUID.randomUUID().toString());
		style.setNom("Nouveau Nom");
		
		this.repoStyleMusical.save(style);
		
		style = this.repoStyleMusical.findById(1).get();
		
		Assertions.assertNotEquals(sonTitre, style.getNom());
	}
	
	@Test
	public void testDeleteById() {
		this.repoStyleMusical.deleteById(1);
		
		Optional<StyleMusical> styleMusicale = this.repoStyleMusical.findById(1);

		Assertions.assertNotNull(styleMusicale);
		Assertions.assertTrue(styleMusicale.isEmpty());
	}
	
	private static StyleMusical generateStyleMusical() {
		StyleMusical style = new StyleMusical();
		
		genericDataForSon(style);
		return style;
	}

	private static void genericDataForSon(StyleMusical style) {
//		Random r = new Random();

		style.setNom(UUID.randomUUID().toString());

//		Method[] meths = style.getClass().getDeclaredMethods();
//		
//		for(Method m : meths) {
//			Class<?>[] types = m.getParameterTypes();
//			int countParam=m.getParameterCount();
//			
//			if(countParam==1 && !m.getName().equals("setId")) {
//				try {
//					if(types[0].isAssignableFrom(String.class)) {				
//						m.invoke(style,UUID.randomUUID().toString());
//					} 				
//					
//				}
//				catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalArgumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
	}
}
