package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractRepositorySql<T> {
	protected Connection connection = null;
	//Méthode pour se connecter
	protected Connection connect( )throws SQLException {
		this.connection= DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/eshop","postgres","secret");		
		return this.connection;
	}
	
	//Méthode pour éxécuter une requete SQL
	protected PreparedStatement prepare(String query) throws SQLException {
		return this.connect().prepareStatement(query);
	}
	//Méthode pour se déconnecter
	protected void disconnect() {
		if(this.connection !=null) {
			try {
				this.connection.close();
			}
			catch(SQLException e) {
				System.out.println("Impossible de fermer la connexion");
			}
		}	
	}
	//On créé ici la méthode map SANS LA REMPLIR pour forcer les classes filles à l'utiliser
	//avec une généricité pour l'utiliser avec n'importe quel objet
	protected abstract T map(ResultSet result);
}
