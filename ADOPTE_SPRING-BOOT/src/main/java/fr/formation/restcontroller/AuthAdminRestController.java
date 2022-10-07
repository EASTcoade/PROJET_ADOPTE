package fr.formation.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Admin;
import fr.formation.model.JsonViews;


@RestController
@RequestMapping("/api/auth/admin")
@CrossOrigin(origins="*")
public class AuthAdminRestController {
//	@Autowired
//	private IMamanRepository mamanRepo;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public Admin authentification(@AuthenticationPrincipal Admin admin) {
		return admin;
	}
	
//	@GetMapping("/check/{login}")
//	public boolean checkLoginExists(@PathVariable String login) {
//		return mamanRepo.findByUsername(login).isPresent();
//	}
}
