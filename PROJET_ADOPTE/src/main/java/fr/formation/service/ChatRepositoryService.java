package fr.formation.service;


import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Chat;
import fr.formation.model.Reception;
import fr.formation.model.Utilisateur;
import fr.formation.repo.jpa.ChatRepositoryJpa;
import fr.formation.repo.jpa.ReceptionRepositoryJpa;
import fr.formation.repo.sql.ChatRepositorySql;

public class ChatRepositoryService {
	
	private ChatRepositoryJpa chatRepo = new ChatRepositoryJpa();
	
	public Chat findById(int id) throws IdNegativeException, ItemNotFoundException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Chat chat = this.chatRepo.findById(id);

		if (chat == null) {
			throw new ItemNotFoundException();
		}
		
		return chat;
	}
	
	
	public void save(Chat chat) throws NotValidException {
		if(chat.getExpediteur()==null) {
			throw new NotValidException();
		}
		if(chat.getDestinataires()==null||chat.getDestinataires().size()<=0) {
			throw new NotValidException();
		}
		this.chatRepo.save(chat);
		
		int idChat = chat.getId();
		ReceptionRepositoryJpa repoReception = new ReceptionRepositoryJpa();
		
		for(Reception reception : chat.getDestinataires()) {
						
			reception.setChat(chat);
			reception.setLu(false);
			reception.setDestinataire(new Utilisateur());
			reception.getDestinataire().setId(1);
			
			repoReception.save(reception);
		}		
	}
	
	
	
	public void deleteById(int id) throws IdNegativeException {
			
		if (id <= 0) {
			throw new IdNegativeException();
		}
		this.chatRepo.deleteById(id);
	}

	

	public List<Chat> findAll() {
		List<Chat> listChat = this.chatRepo.findAll();
	
		if (listChat == null) {
			return new ArrayList<>();
		}
	
		return listChat;
	}
	
	
}
