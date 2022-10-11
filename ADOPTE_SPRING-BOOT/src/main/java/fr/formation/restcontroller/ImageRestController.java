package fr.formation.restcontroller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ImageNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.SonNotFoundException;
import fr.formation.model.FormatImage;
import fr.formation.model.FormatSon;
import fr.formation.model.Image;
import fr.formation.model.JsonViews;
import fr.formation.model.Son;
import fr.formation.model.Utilisateur;
import fr.formation.service.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins="*")
public class ImageRestController {
	@Autowired
	private ImageService imageService;
	
	@GetMapping("")
	@JsonView(JsonViews.Image.class)
	public List<Image> findAll() {
		return imageService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Image.class)
	public Image findById(@PathVariable("id") Integer id) throws IdNegativeException, ImageNotFoundException {
		return imageService.findById(id).get();
	}
	@GetMapping("/{id}/read")
	@JsonView(JsonViews.Image.class)
	public Image findByIdToRead(@PathVariable("id") Integer id) throws IdNegativeException, SonNotFoundException, ImageNotFoundException {
		Image image = new Image();
		image=imageService.findById(id).get();
		return image;
	}

	@PostMapping("")
//		@JsonView(JsonViews.Image.class)
//		public Image create(@Valid @RequestBody Image image, BindingResult br) throws IdNegativeException, ImageNotFoundException, NotValidException {
//			if (br.hasErrors()) {
//				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//			}
//			imageService.save(image);
//			return imageService.findById(image.getId()).get();
//		}
	public Image create(@RequestParam("file") MultipartFile file, @RequestParam("titre") String titre,
		@RequestParam("format") String format) throws IOException, ImageNotFoundException, IdNegativeException {
		Image image = new Image();
		image.setTitre(titre);	
		FormatImage[] formats=FormatImage.values();
		for(FormatImage f : formats) {
			if(format.equals(f.name())) {
				image.setFormat(f);
			}
		}
		byte[] bytesFromFile=file.getBytes();
		image.setContenu(bytesFromFile);
		try {
			imageService.save(image);
		} catch (NotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageService.findById(image.getId()).get();
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Integer id) {
		try {
			imageService.deleteById(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	//@JsonView(JsonViews.ProduitAvecFournisseur.class)
	@PutMapping("/{id}")
	public Image replace(@PathVariable("id") Integer id, @Valid @RequestBody Image image, BindingResult br) throws NotValidException {
		if (br.hasErrors() || !imageService.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		image.setId(id);
		imageService.save(image);
		return image;
	}

	//@JsonView(JsonViews.ProduitAvecFournisseur.class)
	@PatchMapping("/{id}")
	public Image partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Integer id) throws IdNegativeException, ImageNotFoundException, NotValidException {
		Image image = imageService.findById(id).get();
//			
//			//a faire pour tout les champs d'un produit

		fields.forEach((key, value) -> {
//				if (key.equals("utilisateur")) {
//					 traitement de la modif d'un fournisseur
//				} else {
//					 ReflectionUtils.findField =>recuperer un attribut d'une classe
//					 reference,modele,prixAchat,prixVente,id,...
//					 Attribut du json en entree qui doit correspondre à un attribut de la classe
//					 Produit
				Field field = ReflectionUtils.findField(Image.class, key);
//					 on rend le field modifiable
				ReflectionUtils.makeAccessible(field);
//					 on change la VALUE du FIELD du PRODUIT
				ReflectionUtils.setField(field, image, value);
//				}
		});

		imageService.save(image);
		return image;
	}
}

