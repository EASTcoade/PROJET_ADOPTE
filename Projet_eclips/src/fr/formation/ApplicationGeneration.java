package fr.formation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Instrument;
import fr.formation.model.Niveau;
import fr.formation.model.Utilisateur;
import fr.formation.service.InstrumentService;
import fr.formation.service.UtilisateurService;

public class ApplicationGeneration {


	public static void main(String[] args) throws NotValidException, IdNegativeException, ItemNotFoundException{
		//g�n�ration utilisateur
		UtilisateurService srv = new UtilisateurService();
		Utilisateur User1 = new Utilisateur ();
		User1.setNom ("Bernard");
		User1.setMdp("JAVAmal");
		User1.setMail("Bebertdu05@gmail.com");
		User1.setAdresse("20 rue des Mimosas");
		User1.setPseudo("Bebert du 05");
		User1.setAge(80);
		User1.setDateNaissance(LocalDate.parse("1945-10-10"));
		User1.setPrenom("Bernard");
		User1.setNiveau(Niveau.DEBUTANT);
		User1.setTelephone("0782137782");
		InstrumentService srvInstru = new InstrumentService();
		User1.setListeinstrument(new ArrayList<>() );
		User1.getListeinstrument().add(srvInstru. findById(1));
		//User1.setStylemusical(new ArrayList<>() );
		
		srv.save (User1);
		System.out.println("vous êtes bien inscrit");
	}}	
		//g�n�ration instrument
//		InstrumentService srvInstrument = new InstrumentService();
//		Instrument guitare = new Instrument();
//		
//		guitare.setNom("guitare");
//		
//		srvInstrument.save(guitare);
//		System.out.println("Instrument enregistr�");
