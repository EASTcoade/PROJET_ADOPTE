package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.StyleMusical;
import fr.formation.repo.IStyleMusicalRepository;

public class StyleMusicalRepositorySql extends AbstractRepositorySql<StyleMusical> implements IStyleMusicalRepository {

	@Override
	public StyleMusical findById(Integer id) {
		try {		
			PreparedStatement myStatement = this.prepare("SELECT * FROM stylemusical WHERE sty_id = ?");
			myStatement.setInt(1, id);
			ResultSet result = myStatement.executeQuery();
			
			StyleMusical monStyleMusical = null;
			if (result.next()) {
				monStyleMusical = this.map(result);
			}
			return monStyleMusical;
		}
		catch (SQLException e) {
			e.printStackTrace(); 
			return null;
		}
		finally {
			this.disconnect();
		}
	}

	@Override
	public List<StyleMusical> findAll() {
		List<StyleMusical> styleMusicaux = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM stylemusical");
			ResultSet result = myStatement.executeQuery();

			while (result.next()) {
				styleMusicaux.add(this.map(result));
			}
		}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			this.disconnect();
		}
		
		return styleMusicaux;
	}

	@Override
	public void save(StyleMusical entity) {
		try {
			PreparedStatement myStatement = null;
			
			if (entity.getId() == 0) { 
				 myStatement = this.prepare("INSERT INTO stylemusical (sty_nom) VALUES (?)");
			}
			else {
				 myStatement = this.prepare("UPDATE stylemusical SET sty_nom = ? WHERE sty_id = " + entity.getId());
			}
			myStatement.setString(1, entity.getNom());
			myStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace(); // Imprimer l'erreur
		}
		finally {
			this.disconnect();
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("DELETE FROM stylemusical WHERE fou_id = ?");
			myStatement.setInt(1, id);
			myStatement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			this.disconnect();
		}
	}

	@Override
	protected StyleMusical map(ResultSet result) {
		try {
			StyleMusical monStyleMusical = new StyleMusical();
			monStyleMusical.setId(result.getInt("sty_id"));
			monStyleMusical.setNom(result.getString("sty_nom"));			
			return monStyleMusical;
		}
		catch (SQLException e) {
			return null;
		}
	}

}
