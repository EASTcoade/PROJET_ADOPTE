package fr.formation;

import java.time.LocalDate;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Chat;
import fr.formation.model.Niveau;
import fr.formation.model.Utilisateur;
import fr.formation.service.ChatRepositoryService;
import fr.formation.service.UtilisateurService;

public class ApplicationChat {

	public static void main(String[] args) throws NotValidException, IdNegativeException, ItemNotFoundException {
		// TODO Auto-generated method stub
		
		
		UtilisateurService srv = new UtilisateurService();
		Utilisateur user1 = new Utilisateur();
		user1 = srv.findById(3);
		
		Utilisateur user2 = new Utilisateur();
		user2 = srv.findById(4);
		
		ChatRepositoryService repoChat = new ChatRepositoryService();
		Chat chat = new Chat();
		chat.setExpediteur(user1);
		chat.setTexte("bonjour ");
		chat.setDestinataire(user2);
		
		repoChat.save(chat);
	}

}
