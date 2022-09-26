package fr.formation.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Reception;
import fr.formation.model.Reception;
import fr.formation.model.Utilisateur;
import fr.formation.service.NotificationRepositoryService;
import fr.formation.service.ReceptionService;

@RestController
@RequestMapping("/api/Reception")

public class ReceptionRestController {
	@Autowired
	private ReceptionService srvreception;
	

	@GetMapping("")
	public List<Reception> findAll() {
		return srvreception.findAll();
	}

	@GetMapping("/{id}")
	//@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public Reception findById(@PathVariable("id") Integer id) throws IdNegativeException, ItemNotFoundException {
		return srvreception.findById(id).get();
	}


	
	@PostMapping("")
	//@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public Reception create(@Valid @RequestBody Reception reception, BindingResult br) throws IdNegativeException, ItemNotFoundException, NotValidException {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvreception.save(reception);
		return srvreception.findById(reception.getId()).get();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Integer id) {
		try {
			srvreception.deleteById(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	//@JsonView(JsonViews.ProduitAvecFournisseur.class)
	@PutMapping("/{id}")
	public Reception replace(@PathVariable("id") Integer id, @Valid @RequestBody Reception reception, BindingResult br) throws NotValidException {
		if (br.hasErrors() || !srvreception.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		reception.setId(id);
		srvreception.save(reception);
		return reception;
	}

	//@JsonView(JsonViews.ProduitAvecFournisseur.class)
	@PatchMapping("/{id}")
	public Reception partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Integer id) throws IdNegativeException, ItemNotFoundException, NotValidException {
		Reception reception = srvreception.findById(id).get();
//		
//		//a faire pour tout les champs d'un produit

		fields.forEach((key, value) -> {
//			if (key.equals("utilisateur")) {
//				 traitement de la modif d'un fournisseur
//			} else {
//				 ReflectionUtils.findField =>recuperer un attribut d'une classe
//				 reference,modele,prixAchat,prixVente,id,...
//				 Attribut du json en entree qui doit correspondre à un attribut de la classe
//				 Produit
				Field field = ReflectionUtils.findField(Reception.class, key);
//				 on rend le field modifiable
				ReflectionUtils.makeAccessible(field);
//				 on change la VALUE du FIELD du PRODUIT
				ReflectionUtils.setField(field, reception, value);
//			}
		});

		srvreception.save(reception);
		return reception;
	}
}
