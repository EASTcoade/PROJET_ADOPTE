package fr.formation.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.UtilisateurNotFoundException;
import fr.formation.model.JsonViews;
import fr.formation.model.Utilisateur;
import fr.formation.service.StyleMusicalService;
import fr.formation.service.UtilisateurService;


@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurRestController {

		@Autowired
		private UtilisateurService srvUtilisateur;
		@Autowired
		private StyleMusicalService srvStyleMusical;

		//@JsonView(JsonViews.ProduitAvecFournisseur.class)
		@GetMapping("")
		public List<Utilisateur> findAll() {
			return srvUtilisateur.findAll();
		}

//		@GetMapping("/{id}")
//		//@JsonView(JsonViews.ProduitAvecFournisseur.class)
//		public Utilisateur findById(@PathVariable("id") Integer id) throws IdNegativeException, UtilisateurNotFoundException {
//			return srvUtilisateur.findById(id).get();
//		}

		@GetMapping("/{id}/son")
		@JsonView(JsonViews.UtilisateurAvecSon.class)
		public Utilisateur findByIdFetchSon(@PathVariable("id") Integer id) throws IdNegativeException, UtilisateurNotFoundException {
			return srvUtilisateur.findByIdFetchSon(id).get();
		}
		
		@GetMapping("/{id}/style")
		@JsonView(JsonViews.UtilisateurAvecStyle.class)
		public Utilisateur findByIdFetchStyle(@PathVariable("id") Integer id) throws IdNegativeException, UtilisateurNotFoundException {
			return srvUtilisateur.findByIdFetchStyle(id).get();
		}
		
		@GetMapping("/{id}/instrument")
		@JsonView(JsonViews.UtilisateurAvecInstrument.class)
		public Utilisateur findByIdFetchInstrument(@PathVariable("id") Integer id) throws IdNegativeException, UtilisateurNotFoundException {
			return srvUtilisateur.findByIdFetchInstrument(id).get();
		}
		
		@GetMapping("/{id}")
		@JsonView(JsonViews.UtilisateurAvecTout.class)
		public Utilisateur findByIdFetchAll(@PathVariable("id") Integer id) throws IdNegativeException, UtilisateurNotFoundException {
			return srvUtilisateur.findByIdFetchAll(id).get();
		}
		@PostMapping("")
		@JsonView(JsonViews.UtilisateurAvecTout.class)
		public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) throws IdNegativeException, UtilisateurNotFoundException, NotValidException {
			if (br.hasErrors()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			srvUtilisateur.save(utilisateur);
			return srvUtilisateur.findByIdFetchAll(utilisateur.getId()).get();
		}
		@PostMapping("/{uti_id}/{sty_id}")
		@JsonView(JsonViews.UtilisateurAvecTout.class)
		public Utilisateur createLinkStyleUtilisateur(@PathVariable("uti_id") Integer uti_id,@PathVariable("sty_id") Integer sty_id) throws IdNegativeException, UtilisateurNotFoundException{
			if(!srvUtilisateur.existsById(uti_id)||!srvStyleMusical.existsById(sty_id)) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			srvUtilisateur.createLinkStyleUtilisateur(uti_id, sty_id);
			return srvUtilisateur.findByIdFetchAll(uti_id).get();
		}
		@DeleteMapping("/{uti_id}/{sty_id}")
		@JsonView(JsonViews.UtilisateurAvecTout.class)
		public Utilisateur deleteLinkStyleUtilisateur(@PathVariable("uti_id") Integer uti_id,@PathVariable("sty_id") Integer sty_id) throws IdNegativeException, UtilisateurNotFoundException{
			if(!srvUtilisateur.existsById(uti_id)||!srvStyleMusical.existsById(sty_id)) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			srvUtilisateur.deleteLinkStyleUtilisateur(uti_id, sty_id);
			return srvUtilisateur.findByIdFetchAll(uti_id).get();
		}
		@DeleteMapping("/{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void deleteById(@PathVariable("id") Integer id) {
			try {
				srvUtilisateur.deleteById(id);
			} catch (Exception ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
		}

		//@JsonView(JsonViews.ProduitAvecFournisseur.class)
		@PutMapping("/{id}")
		public Utilisateur replace(@PathVariable("id") Integer id, @Valid @RequestBody Utilisateur utilisateur, BindingResult br) throws NotValidException {
			if (br.hasErrors() || !srvUtilisateur.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			utilisateur.setId(id);
			srvUtilisateur.save(utilisateur);
			return utilisateur;
		}

		@JsonView(JsonViews.UtilisateurAvecTout.class)
		@PatchMapping("/{id}")
		public Utilisateur partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Integer id) throws IdNegativeException, UtilisateurNotFoundException, NotValidException {
			Utilisateur utilisateur = srvUtilisateur.findByIdFetchAll(id).get();
//			if(fields.get("reference")!=null) {
//				produit.setReference(fields.get("reference").toString());
//			}
//			if(fields.get("modele")!=null) {
//				produit.setReference(fields.get("modele").toString());
//			}
//			if(fields.get("nom")!=null) {
//				produit.setReference(fields.get("nom").toString());
//			}
//			//a faire pour tout les champs d'un produit

			fields.forEach((key, value) -> {
//				if (key.equals("stylemusical")) {
//				
//				} else {
//					 ReflectionUtils.findField =>recuperer un attribut d'une classe
//					 reference,modele,prixAchat,prixVente,id,...
//					 Attribut du json en entree qui doit correspondre à un attribut de la classe
//					 Produit
					Field field = ReflectionUtils.findField(Utilisateur.class, key);
//					 on rend le field modifiable
					ReflectionUtils.makeAccessible(field);
//					 on change la VALUE du FIELD du PRODUIT
					ReflectionUtils.setField(field, utilisateur, value);
//				}
			});

			srvUtilisateur.save(utilisateur);
			return utilisateur;
		}
	}

	
	
	

