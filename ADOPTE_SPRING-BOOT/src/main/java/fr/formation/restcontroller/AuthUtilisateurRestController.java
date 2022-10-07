package fr.formation.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Admin;
import fr.formation.model.JsonViews;
import fr.formation.model.Utilisateur;


@RestController
@RequestMapping("/api/auth/utilisateur")
@CrossOrigin(origins="*")
public class AuthUtilisateurRestController {
//	@Autowired
//	private IMamanRepository mamanRepo;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public Utilisateur authentification(@AuthenticationPrincipal Utilisateur uti) {
		return uti;
	}
	
//	@GetMapping("/check/{login}")
//	public boolean checkLoginExists(@PathVariable String login) {
//		return mamanRepo.findByUsername(login).isPresent();
//	}
}
