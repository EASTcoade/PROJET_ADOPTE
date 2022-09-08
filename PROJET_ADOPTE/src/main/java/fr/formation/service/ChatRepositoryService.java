package fr.formation.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Chat;
import fr.formation.model.Reception;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IChatRepository;

@Service
public class ChatRepositoryService {
	
	@Autowired
	private IChatRepository chatRepo;
	
	public Optional<Chat> findById(int id) throws IdNegativeException, ItemNotFoundException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		
		Optional<Chat> chat = this.chatRepo.findById(id);

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
		
//		int idChat = chat.getId();
		
		for(Reception reception : chat.getDestinataires()) {
						
			reception.setChat(chat);
			reception.setLu(false);
			reception.setDestinataire(new Utilisateur());
			reception.getDestinataire().setId(1);
		
		}
		this.chatRepo.save(chat);
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
