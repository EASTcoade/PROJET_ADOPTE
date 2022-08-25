package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Chat;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IChatRepository;

public class ChatRepositorySql extends AbstractRepositorySql<Chat> implements IChatRepository {

	
	@Override
	protected Chat map(ResultSet result) {
		try {
			Chat chat = new Chat();
			
			UtilisateurRepositorySql utiRepo = new UtilisateurRepositorySql()  ;
			
			chat.setTexte( result.getString("chat_recu") );
			chat.setExpediteur( utiRepo.findById( result.getInt("chat_uti_id") ) );
			
			return chat;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
	
	
	@Override
	public Chat findById(Integer id) {
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM chat WHERE id = ?");
			ResultSet myResult = myStatement.executeQuery();
			
			if (myResult.next()) {
				return this.map(myResult);
			}
		}
		
		catch (SQLException e) { e.printStackTrace();	}
		
		finally { this.disconnect(); }
		
		return null;
	}

	@Override
	public List<Chat> findAll() {
		List<Chat> listChat = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM chat");
			ResultSet myResult = myStatement.executeQuery();
			
			while (myResult.next()) {
				listChat.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) { e.printStackTrace();} // On le laisse en dév | TODO : à supprimer plus tard
		
		finally { this.disconnect(); }
		
		return listChat;
	}
	

	@Override
	public void save(Chat entity) {
		return;
	}
		

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("DELETE FROM chat WHERE chat_id = ?");
			myStatement.setInt(1, id);
			myStatement.execute();
		}
		
		catch (SQLException e) { e.printStackTrace(); }
		
		finally { this.disconnect(); }
	}		
}


