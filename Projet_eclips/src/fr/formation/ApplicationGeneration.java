package fr.formation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Instrument;
import fr.formation.model.Niveau;
import fr.formation.model.StyleMusical;
import fr.formation.model.Utilisateur;
import fr.formation.service.InstrumentService;
import fr.formation.service.StyleMusicalService;
import fr.formation.service.UtilisateurService;

public class ApplicationGeneration {


	public static void main(String[] args) throws NotValidException, IdNegativeException, ItemNotFoundException{
		//generation utilisateur
		UtilisateurService srv = new UtilisateurService();
		Utilisateur user1 = new Utilisateur ();
		user1.setNom ("Bernard");
		user1.setMdp("JAVAmal");
		user1.setMail("Bebertdu05@gmail.com");
		user1.setAdresse("20 rue des Mimosas");
		user1.setPseudo("Bebert du 05");
		user1.setAge(80);
		user1.setDateNaissance(LocalDate.parse("1945-10-10"));
		user1.setPrenom("Bernard");
		user1.setNiveau(Niveau.DEBUTANT);
		user1.setTelephone("0782137782");
		InstrumentService srvInstru = new InstrumentService();
		user1.setListeinstrument(new ArrayList<>() );
		user1.getListeinstrument().add(srvInstru. findById(1));
		StyleMusicalService srvStyle = new StyleMusicalService();
		user1.setStylemusical(new ArrayList<>());
		user1.getStylemusical().add(srvStyle.findById(1));
		
		//User1.setStylemusical(new ArrayList<>() );
		
		srv.save (user1);
		System.out.println("vous etes bien inscrit");
		
		//generation instrument
//		InstrumentService srvInstrument = new InstrumentService();
//		Instrument guitare = new Instrument();
//		
//		guitare.setNom("guitare");
//		
//		srvInstrument.save(guitare);
//		System.out.println("Instrument enregistre);
		
//		//generation styles musicaux
//		StyleMusicalService srvStyle = new StyleMusicalService();
//		StyleMusical jazz = new StyleMusical();
//		
//		jazz.setNom("jazz");
//		
//		srvStyle.save(jazz);
//		System.out.println("style musical enregistre !");
		
	}
}	
		

		
		
		
