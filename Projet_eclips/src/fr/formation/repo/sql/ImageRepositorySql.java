package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Image;
import fr.formation.model.Image;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IImageRepository;

public class ImageRepositorySql extends AbstractRepositorySql<Image> implements IImageRepository{
	@Override
	protected Image map(ResultSet result) {
		try {
			Image monImage = new Image();
			
			monImage.setId(result.getInt("ima_id"));
			monImage.setTitre(result.getString("ima_nom"));
			
			
			monImage.setContenu(result.getBytes("ima_contenu"));
			return monImage;			
		}
		catch(SQLException e) {
			return null;
		}
	}
	public Image findById(Integer id) {
		Image monImage = null;
		try {
			PreparedStatement myStatement=this.prepare("SELECT * from image WHERE ima_id=?");
			
			myStatement.setInt(1, id);
			
			ResultSet myResult = myStatement.executeQuery();				
			
			if(myResult.next()) {
				monImage = this.map(myResult);
			}
			return monImage;	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();			
		}
		return monImage;
	}
	public List<Image> findAll(){
		List<Image> images = new ArrayList<>();
		try {
			PreparedStatement myStatement=this.prepare("Select * from image");
			ResultSet myResult = myStatement.executeQuery();
			
			while(myResult.next()) {
				images.add(this.map(myResult));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return images;
	}
	public void save(Image entity) {
		try {
			PreparedStatement myStatement=null;
			if(entity.getId()==0) {//c'est un INSERT 
				myStatement=this.prepare("INSERT INTO image (ima_nom,ima_format,ima_contenu)"
						+ "VALUES(?,?,?)");
				myStatement.setString(1,entity.getTitre());
				myStatement.setInt(2,entity.getFormat().ordinal());
				myStatement.setBytes(3, entity.getContenu());
				
				myStatement.execute();
			}else {//c'est un UPDATE
				myStatement=this.prepare("UPDATE image "
						+ "SET ima_nom = ?,"
						+ "ima_contenu = ?"
						+ "ima_format = ?"
						+ "WHERE son_id=?");
						
				myStatement.setString(1,entity.getTitre());
				myStatement.setInt(2,entity.getFormat().ordinal());
				myStatement.setBytes(3, entity.getContenu());				
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
			PreparedStatement myStatement=this.prepare("DELETE from image WHERE ima_id=?");
			
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
