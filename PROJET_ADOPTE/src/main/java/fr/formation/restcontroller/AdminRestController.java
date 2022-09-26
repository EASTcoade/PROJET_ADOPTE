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
import fr.formation.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	
	@Autowired AdminService srvAdmin;
	
	@GetMapping("")	
//	@JsonView(JsonViews.Admin.class)
	public List<Admin> findAll(){
		return srvAdmin.findAll();
	}
	
	@GetMapping("/{id}")
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public Admin findById(@PathVariable("id") int id) throws IdNegativeException, ItemNotFoundException {
		return srvAdmin.findById(id).get();
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public Admin create(@Valid @RequestBody Admin admin, BindingResult br) throws NotValidException {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvAdmin.save(admin);
		return admin;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) throws IdNegativeException {
		try {
			srvAdmin.deleteById(id);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public Admin replace(@PathVariable("id") int id,@Valid @RequestBody Admin admin, BindingResult br) throws IdNegativeException, ItemNotFoundException, NotValidException {
		
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvAdmin.findById(id);
		admin.setId(id);
		srvAdmin.save(admin);
		return admin;		
	}
	
	//modification partielle
	@PatchMapping("/{id}")
//	@JsonView(JsonViews.ProduitAvecFournisseur.class)
	public Admin modify(@PathVariable("id") int id,@RequestBody Map<String, Object> fields) throws IdNegativeException, ItemNotFoundException, NotValidException {
		Admin admin = srvAdmin.findById(id).get();
		
		fields.forEach((key,value)->{
//			if(key.equals("fournisseur")) {
//				//traitement de la modif d'un fournisseur qui sera un peu particulier
//			}else {
			Field field=ReflectionUtils.findField(Admin.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, admin, value);
//			}
		});	
		srvAdmin.save(admin);
		return admin;
	}
}
