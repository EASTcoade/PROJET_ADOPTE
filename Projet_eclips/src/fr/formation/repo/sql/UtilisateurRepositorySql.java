package fr.formation.repo.sql;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.formation.model.Utilisateur;

import fr.formation.repo.IUtilisateurRepository;

public  class UtilisateurRepositorySql extends AbstractRepositorySql<Utilisateur> implements IUtilisateurRepository { 
	

	
	
	
	
	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateur = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM utilisateur");
			ResultSet myResult = myStatement.executeQuery();
			
			while (myResult.next()) {
				utilisateur.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // On le laisse en dév | TODO : à supprimer plus tard
		}
		
		finally {
			this.disconnect();
		}
		
		return utilisateur;
	}

	@Override
	public Utilisateur findById(Integer id) {
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM utilisateur WHERE uti_id = ?");
			
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
	public void save(Utilisateur entity) {
		try {
			PreparedStatement myStatement = null;
			
			if (entity.getId() == 0) { // INSERT
				myStatement = this.prepare("INSERT INTO utilisateur (uti_mdp, uti_nom, uti_prenom, uti_pseudo, uti_date_naissance, uti_adresse, uti_tel, uti_niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			}
			
			else { // UPDATE
				myStatement = this.prepare("UPDATE utilisteur SET " 
			+ "uti_mdp = ?, " 
			+ "uti_nom = ?, " 
			+ "uti_prenom =?," 
			+"uti_pseudo=?," 
			+ "uti_date_naissance=?,"
			+"uti_adresse=?,"
			+"uti_tel=?,"
			+"uti_niveau=?," 
			+ "WHERE uti_id = ?,");

				myStatement.setInt(9, entity.getId());
			}
			
			myStatement.setString(1, entity.getMdp());
			myStatement.setString(2, entity.getNom());
			myStatement.setString(3, entity.getPrenom());
			myStatement.setString(4, entity.getPseudo());
			myStatement.setDate(5, Date.valueOf(entity.getDateNaissance()));
			myStatement.setString(6, entity.getAdresse());
			myStatement.setString(7, entity.getTelephone());
			myStatement.setInt(8, entity.getNiveau().ordinal());
			
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
			PreparedStatement myStatement = this.prepare("DELETE FROM utilisateur WHERE uti_id = ?");
			
			myStatement.setInt(1, id);
			
			myStatement.executeUpdate();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	

	@Override
	protected Utilisateur map(ResultSet myResult) {
		try {
			// Pour chaque résultat, il faudra créer un nouveau Fournisseur
			Utilisateur monUtilisateur = new Utilisateur();
			
			// On associe toutes les infos du fournisseur
			monUtilisateur.setId( myResult.getInt("uti_id") );
			monUtilisateur.setMdp( myResult.getString("uti_mdp") );
			monUtilisateur.setNom( myResult.getString("uti_nom") );
			monUtilisateur.setPrenom( myResult.getString("uti_prenom") );
			monUtilisateur.setPseudo( myResult.getString("uti_pseudo") );
			monUtilisateur.setDateNaissance(myResult.getDate("uti_date_naissance").toLocalDate() );
			monUtilisateur.setAdresse( myResult.getString("uti_adresse") );
			monUtilisateur.setTelephone( myResult.getString("uti_tel") );
			
			
			
			
			return monUtilisateur;
		}
		
		catch (SQLException e) {
			return null;
		}
	
	}
}
