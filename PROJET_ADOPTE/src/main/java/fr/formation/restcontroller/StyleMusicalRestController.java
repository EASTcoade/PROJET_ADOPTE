package fr.formation.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.UtilisateurNotFoundException;
import fr.formation.model.Admin;
import fr.formation.model.StyleMusical;
import fr.formation.service.StyleMusicalService;

@RestController
@RequestMapping("/api/style")
public class StyleMusicalRestController {

	@Autowired StyleMusicalService srvStyle;
	
	@GetMapping("")	
//	@JsonView(JsonViews.Admin.class)
	public List<StyleMusical> findAll(){
		return srvStyle.findAll();
	}
	
	@GetMapping("/{id}")
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public StyleMusical findById(@PathVariable("id") int id) throws IdNegativeException, UtilisateurNotFoundException, ItemNotFoundException {
		return srvStyle.findById(id).get();
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public StyleMusical create(@Valid @RequestBody StyleMusical style, BindingResult br) throws NotValidException {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvStyle.save(style);
		return style;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) throws IdNegativeException {
		try {
			srvStyle.deleteById(id);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public StyleMusical replace(@PathVariable("id") int id,@Valid @RequestBody StyleMusical style, BindingResult br) throws IdNegativeException, UtilisateurNotFoundException, NotValidException, ItemNotFoundException {
		
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvStyle.findById(id);
		style.setId(id);
		srvStyle.save(style);
		return style;		
	}
	
	//modification partielle
	@PatchMapping("/{id}")
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public StyleMusical modify(@PathVariable("id") int id,@RequestBody Map<String, Object> fields) throws IdNegativeException, UtilisateurNotFoundException, NotValidException, ItemNotFoundException {
		StyleMusical style = srvStyle.findById(id).get();
		
		fields.forEach((key,value)->{
//			if(key.equals("fournisseur")) {
//				//traitement de la modif d'un fournisseur qui sera un peu particulier
//			}else {
			Field field=ReflectionUtils.findField(Admin.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, style, value);
//			}
		});	
		srvStyle.save(style);
		return style;
	}
}
