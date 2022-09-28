package fr.formation.repo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
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

import fr.formation.config.AppConfig;
import fr.formation.model.reception;
import fr.formation.model.Niveau;
import fr.formation.model.StyleMusical;
import fr.formation.model.Utilisateur;


@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
@Sql(scripts = "classpath:/data.sql")

public class UtilisateurRepositoryTest {
	@Autowired
	private IUtilisateurRepository repoUtilisateur ;
	

	
	@Test
	public void testFindAll() {
		List<Utilisateur> utilisateur = this.repoUtilisateur.findAll();
		Assertions.assertNotNull(utilisateur);
		
	}
	@Test
	public void testFindById() {
		Optional<Utilisateur> utilisateur = this.repoUtilisateur.findById(1);
		
		Assertions.assertNotNull(utilisateur);
		Assertions.assertTrue(utilisateur.isPresent());
	}
	
	
	@Test
	public void testDeleteById() {
		this.repoUtilisateur.deleteById(2);
		Assertions.assertNotNull(this.repoUtilisateur.findById(2));
		Assertions.assertTrue(this.repoUtilisateur.findById(2).isEmpty());
		
		
	}
	@Test
	public void shouldAdd() {
		Utilisateur utilisateur = generateUtilisateur();
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
		
		
		StyleMusical stylemusical = new StyleMusical();
		ArrayList<StyleMusical> stylemusicaux = new ArrayList<>();
		
		stylemusical.setNom("metal");
		stylemusicaux.add(stylemusical);
		
		utilisateur.setStylemusical(stylemusicaux);
		this.repoUtilisateur.save(utilisateur);

		Assertions.assertNotEquals(0, utilisateur.getId());
	}
	
	@Test
	public void shouldUpdate() {
		Utilisateur utilisateur = this.repoUtilisateur.findById(1).get();
		String randomName = UUID.randomUUID().toString();
		
		utilisateur.setNom(randomName);
		
		
		this.repoUtilisateur.save(utilisateur);
		
		utilisateur = this.repoUtilisateur.findById(1).get();
		
		Assertions.assertEquals(randomName, utilisateur.getNom());
	}
	private static Utilisateur generateUtilisateur() {
		Utilisateur Utilisateur = new Utilisateur();
		
		genericDataForUtilisateur(Utilisateur);
		return Utilisateur;
	}
	
	private static void genericDataForUtilisateur(Utilisateur utilisateur){
		Random r = new Random();
		
		Method[] meths = utilisateur.getClass().getDeclaredMethods();
		
		for(Method m : meths) {
			Class<?>[] types = m.getParameterTypes();
			int countParam=m.getParameterCount();
			
			if(countParam==1 && !m.getName().equals("setId")) {
				try {
					if(types[0].isAssignableFrom(String.class)) {
						m.invoke(utilisateur,(UUID.randomUUID().toString().substring(0, 9)));
					} 
					if(types[0].isAssignableFrom(int.class)||types[0].isAssignableFrom(Integer.class)) {				
						m.invoke(utilisateur,r.nextInt());
					}
					if(types[0].isAssignableFrom(float.class)||types[0].isAssignableFrom(Float.class)) {				
						m.invoke(utilisateur,r.nextInt());
					}
					if(types[0].isAssignableFrom(Niveau.class)) {
						m.invoke(utilisateur, Niveau.DEBUTANT); //mettre niveau en aleatoire?
					}
					if(types[0].isAssignableFrom(LocalDate.class)) {				
						m.invoke(utilisateur, LocalDate.now());
					}
					if(types[0].isAssignableFrom(reception.class)) {				
						utilisateur.setPhotoprofil(new reception());
						utilisateur.getPhotoprofil().setId(1);
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
