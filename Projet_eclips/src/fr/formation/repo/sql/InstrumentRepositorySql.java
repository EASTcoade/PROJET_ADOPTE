package fr.formation.repo.sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instrument> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}
}
