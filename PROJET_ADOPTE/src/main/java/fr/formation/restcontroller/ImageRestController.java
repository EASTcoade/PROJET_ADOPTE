package fr.formation.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ImageNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Image;
import fr.formation.service.ImageService;

@Controller
@RequestMapping("/api/image")

public class ImageRestController {
	
		
		@Autowired
		private ImageService imageService;
		
		@GetMapping("")
		public String list(Model model) {
			model.addAttribute("image", imageService.findAll()Reception);
			return "image/list";
		}
		
		@GetMapping("/ajouter")
		public String ajouter(Model model) {
			return goEdit(new Image(), model);
		}
		
		private String goEdit(Image image,Model model) {
			model.addAttribute("image", image);
			return "image/edit";
		}
		
		
		@GetMapping("/supprimer")
		public String supprimer(@RequestParam Integer id) throws IdNegativeException  {
			imageService.deleteById(id);
			return "redirect:/image";
		}
		
		@GetMapping("/modifier")
		public String modifier(@RequestParam int id,Model model) throws ImageNotFoundException, IdNegativeException {
			return goEdit(imageService.findById(id).get(),model);
		}
		
		@PostMapping("")
		public String enregistrer(@Valid @ModelAttribute Image image,BindingResult br,Model model) throws NotValidException {
			if(br.hasErrors()) {
				System.out.println(br);
				return goEdit(image, model);
			}
			imageService.save(image);
			return "redirect:/image";
		}
}

