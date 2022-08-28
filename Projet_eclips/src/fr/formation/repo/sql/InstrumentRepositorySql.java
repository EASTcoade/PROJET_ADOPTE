package fr.formation.repo.sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Instrument;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IInstrumentRepository;

public class InstrumentRepositorySql extends AbstractRepositorySql<Instrument> implements IInstrumentRepository{
	protected Instrument map(ResultSet myresult) {
		try {
			Instrument monInstrument = new Instrument();
			
			monInstrument.setId(myresult.getInt("ins_id"));
			monInstrument.setNom(myresult.getString("ins_nom"));
			
			//on associe toute les infos de l'instrument
			return monInstrument;
		}
		
		catch (SQLException e) {
			//imprimer l'erreur
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return null;
		//rajouter id utilisateur?
	}

	@Override
	public Instrument findById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM instrument WHERE ins_id = ?");
			
			myStatement.setInt(1, id);
			
			ResultSet myResult = myStatement.executeQuery();
			
			if (myResult.next()) {
				return this.map(myResult);
			}
		}
		
		catch (SQLException e) {
			return null;			
		}
		
		finally {
			this.disconnect();
		}
		
		return null;
	}

	@Override
	public List<Instrument> findAll() {
		List<Instrument> instrument = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM instrument");
			ResultSet myResult = myStatement.executeQuery();
			
			while (myResult.next()) {
				instrument.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // On le laisse en dév | TODO : à supprimer plus tard
		}
		
		finally {
			this.disconnect();
		}
		
		return instrument;
	}

	@Override
	public void save(Instrument entity) {
		try {
			PreparedStatement myStatement = null;
			
			if (entity.getId() == 0) { // INSERT
				myStatement = this.prepare("INSERT INTO instrument (ins_nom) VALUES (?)");
			}
			
			else { // UPDATE
				myStatement = this.prepare("UPDATE instrument SET "
			+ "ins_nom = ?, "
			+ "WHERE ins_id = ?");

				myStatement.setInt(2, entity.getId());
			}			
			myStatement.setString(1, entity.getNom());		
			
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
	public void deleteById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("DELETE FROM instrument WHERE uti_id = ?");
			
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
}
