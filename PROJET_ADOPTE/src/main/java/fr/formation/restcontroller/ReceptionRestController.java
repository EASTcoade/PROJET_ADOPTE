package fr.formation.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ImageNotFoundException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;

import fr.formation.model.Reception;
import fr.formation.service.NotificationRepositoryService;
import fr.formation.service.ReceptionService;

@RestController
@RequestMapping("/api/Reception")

public class ReceptionRestController {
	@Autowired
	private NotificationRepositoryService receptionRepo;
	
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("reception", ReceptionService.findAll());
		return "reception/list";
	}
	
	@GetMapping("/ajouter")
	public String ajouter(Model model) {
		return goEdit(new Reception(), model);
	}
	
	private String goEdit(Reception reception,Model model) {
		model.addAttribute("reception", reception);
		return "reception/edit";
	}
	
	
	@GetMapping("/supprimer")
	public String supprimer(@RequestParam Integer id) throws IdNegativeException  {
		ReceptionService.deleteById(id);
		return "redirect:/reception";
	}
	
	@GetMapping("/modifier")
	public String modifier(@RequestParam int id,Model model) throws IdNegativeException, ItemNotFoundException {
		return goEdit(ReceptionService.findById(id).get(),model);
	}
	
	@PostMapping("")
	public String enregistrer(@Valid @ModelAttribute reception reception,BindingResult br,Model model) throws NotValidException {
		if(br.hasErrors()) {
			System.out.println(br);
			return goEdit(reception, model);
		}
		receptionService.save(reception);
		return "redirect:/reception";
	}
}
