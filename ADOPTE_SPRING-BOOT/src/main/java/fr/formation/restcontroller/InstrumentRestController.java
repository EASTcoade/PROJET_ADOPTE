package fr.formation.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Instrument;
import fr.formation.model.JsonViews;
import fr.formation.model.JsonViews.UtilisateurAvecSon;
import fr.formation.model.JsonViews.UtilisateurAvecStyle;
import fr.formation.model.Utilisateur;
import fr.formation.service.InstrumentService;

@RestController
@RequestMapping("/api/instrument")
@CrossOrigin(origins="*")
public class InstrumentRestController {
	
		@Autowired
		private InstrumentService instrumentService;
		
		@GetMapping("")
		@JsonView(JsonViews.Instrument.class)
		public List<Instrument> findAll() {
			return instrumentService.findAll();
		}
		@GetMapping("/{id}")
		@JsonView(JsonViews.Instrument.class)
		public Instrument findById(@PathVariable("id") Integer id) throws IdNegativeException, ItemNotFoundException {			
			Instrument val= instrumentService.findById(id);
			return val;
		}
		
		@GetMapping("/utilisateurs")
		@JsonView(JsonViews.Instrument.class)
		public List<Instrument> findAllFetchJoueurs() {
			return instrumentService.findAllFetchJoueurs();
		}
		
		@GetMapping("/{id}/utilisateurs")
		@JsonView(JsonViews.UtilisateurAvecTout.class)
		public List<Utilisateur> findAllUtilisateurByInstrument(@PathVariable("id") Integer id) throws IdNegativeException, ItemNotFoundException{
			return instrumentService.findAllUtilisateurByInstrument(id);
		}
		
		@GetMapping("/ajouter")
		public String ajouter(Model model) {
			return goEdit(new Instrument(), model);
		}
		
		private String goEdit(Instrument instrument,Model model) {
			model.addAttribute("instrument", instrument);
			return "instrument/edit";
		}
		
		
		@GetMapping("/supprimer")
		public String supprimer(@RequestParam Integer id) throws IdNegativeException {
			instrumentService.deleteById(id);
			return "redirect:/instrument";
		}
		
		@GetMapping("/modifier")
		public String modifier(@RequestParam int id,Model model) throws IdNegativeException, ItemNotFoundException {
			return goEdit(instrumentService.findById(id),model);
		}
		
		@PostMapping("")
		@JsonView(JsonViews.Instrument.class)
		public Instrument enregistrer(@RequestBody Instrument instrument) throws NotValidException {
			instrumentService.save(instrument);
			return instrument;
		}
}
