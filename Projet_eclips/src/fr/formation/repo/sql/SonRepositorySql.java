package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Son;
import fr.formation.model.Utilisateur;
import fr.formation.repo.ISonRepository;

public class SonRepositorySql extends AbstractRepositorySql<Son> implements ISonRepository{

	@Override
	protected Son map(ResultSet result) {
		try {
			Son monSon = new Son();
			
			monSon.setId(result.getInt("son_id"));
			monSon.setTitre(result.getString("son_nom"));
			
			Utilisateur monUti = new Utilisateur();
			monUti.setId(result.getInt("son_uti_id"));
			
			monSon.setContenu(result.getBytes("son_contenu"));
			return monSon;			
		}
		catch(SQLException e) {
			return null;
		}
	}
	public Son findById(Integer id) {
		Son monSon = null;
		try {
			PreparedStatement myStatement=this.prepare("SELECT * from son WHERE son_id=?");
			
			myStatement.setInt(1, id);
			
			ResultSet myResult = myStatement.executeQuery();				
			
			if(myResult.next()) {
				monSon = this.map(myResult);
			}
			return monSon;	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();			
		}
		return monSon;
	}
	public List<Son> findAll(){
		List<Son> sons = new ArrayList<>();
		try {
			PreparedStatement myStatement=this.prepare("Select * from fournisseur");
			ResultSet myResult = myStatement.executeQuery();
			
			while(myResult.next()) {
				sons.add(this.map(myResult));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return sons;
	}
	public void save(Son entity) {
		try {
			PreparedStatement myStatement=null;
			if(entity.getId()==0) {//c'est un INSERT 
				myStatement=this.prepare("INSERT INTO son (son_nom,son_uti_id,son_contenu)"
						+ "VALUES(?,?,?)");
				myStatement.setString(1,entity.getTitre());
				myStatement.setInt(2,entity.getCreateur().getId());
				myStatement.setBytes(3, entity.getContenu());
				
				myStatement.execute();
			}else {//c'est un UPDATE
				myStatement=this.prepare("UPDATE son "
						+ "SET son_nom = ?,"
						+ "son_uti_id = ?"
						+ "son_contenu = ?"
						+ "WHERE son_id=?");
						
				myStatement.setString(1,entity.getTitre());
				myStatement.setInt(2,entity.getCreateur().getId());
				myStatement.setBytes(3, entity.getContenu());
				myStatement.setInt(4,entity.getId());				
			}
			myStatement.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();			
		}	
	}
	
	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement myStatement=this.prepare("DELETE from son WHERE fou_id=?");
			
			myStatement.setInt(1, id);
			
			myStatement.executeUpdate();
							
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();			
		}
		
	}
	
}
