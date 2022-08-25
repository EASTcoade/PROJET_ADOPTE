package fr.formation.service;


import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.model.Chat;
import fr.formation.repo.sql.ChatRepositorySql;

public class ChatRepositoryService {
	
	ChatRepositorySql chatRepo = new ChatRepositorySql();
	
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
