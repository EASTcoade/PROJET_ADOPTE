package fr.formation.service;


import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Chat;
import fr.formation.repo.sql.ChatRepositorySql;

public class ChatRepositoryService {
	
	ChatRepositorySql chatRepo = new ChatRepositorySql();
	
	public Chat findById(int id) {
		
		Chat chat = this.chatRepo.findById(id);
		
		return chat;
	}
	
	
	
	public void deleteById(int id) {
			
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
