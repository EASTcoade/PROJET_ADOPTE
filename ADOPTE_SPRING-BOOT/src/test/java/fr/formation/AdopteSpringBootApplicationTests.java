package fr.formation;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import fr.formation.exception.NotValidException;
import fr.formation.model.Admin;
import fr.formation.model.Niveau;
import fr.formation.model.Utilisateur;
import fr.formation.service.AdminService;
import fr.formation.service.UtilisateurService;

@SpringBootTest
class AdopteSpringBootApplicationTests {
	
	@Autowired
	private AdminService srvAdmin;
	@Autowired
	private UtilisateurService srvUtilisateur;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Test
	void contextLoads() {
	}
	@Test
	@Transactional
	@Commit
	void initAdmin() throws NotValidException {
		Admin superman=new Admin("superman",passwordEncoder.encode("mdp3"));
		srvAdmin.save(superman);
		Admin batman=new Admin("batman",passwordEncoder.encode("mdp4"));
		srvAdmin.save(batman);
	}
	
//	@Test
//	@Transactional
//	@Commit
//	void initUtilisateur() throws NotValidException {
//		Utilisateur uti1=new Utilisateur("uti1",passwordEncoder.encode("mdp3"),"leNom","lePrenom","test@gmail.com","2 rue inconnue",
//				"0987987876",Niveau.DEBUTANT,LocalDate.of(1996, 2, 1));
//		srvUtilisateur.save(uti1);
//		Utilisateur uti2=new Utilisateur("uti2",passwordEncoder.encode("mdp4"),"leNom2","lePrenom","test@gmail.com","2 rue inconnue",
//				"0987987876",Niveau.DEBUTANT,LocalDate.of(1996, 2, 1));
//		srvUtilisateur.save(uti2);
//	}	
}
