package fr.formation.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.SonNotFoundException;
import fr.formation.model.JsonViews;
import fr.formation.model.Son;
import fr.formation.service.SonService;

@RestController
@RequestMapping("/api/son")
@CrossOrigin(origins="*")
public class SonRestController {
	
	@Autowired
	private SonService srvSon;
	
	@GetMapping("")
	//@JsonView(JsonView.Son.class)
	public List<Son> findAll() {
		return srvSon.findAll();
	}

	@GetMapping("/{id}/son")
	//@JsonView(JsonViews.Son.class)
	public Son findById(@PathVariable("id") Integer id) throws IdNegativeException, SonNotFoundException {
		return srvSon.findById(id).get();
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Son.class)
	public Son create(@Valid @RequestBody Son son,BindingResult br) throws NotValidException {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvSon.save(son);
		return son;
	}
	
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		try {
			srvSon.deleteById(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	

	//@JsonView(JsonViews.Fournisseur.class)
	@PutMapping("/{id}")
	public Son replace(@PathVariable("id") Integer id,@Valid @RequestBody Son son,BindingResult br) throws IdNegativeException, SonNotFoundException, NotValidException {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		srvSon.findById(id);
		System.out.println("apres findById");
		son.setId(id);
		srvSon.save(son);
		return son;
	}
	
}
