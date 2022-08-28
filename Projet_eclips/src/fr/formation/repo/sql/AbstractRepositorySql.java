package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractRepositorySql<T> {
	protected Connection connection = null;
	//M�thode pour se connecter
	protected Connection connect( )throws SQLException {
		this.connection= DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/sans_bemol","postgres","secret");		
		return this.connection;
	}
	
	//M�thode pour �x�cuter une requete SQL
	protected PreparedStatement prepare(String query) throws SQLException {
		return this.connect().prepareStatement(query);
	}
	
	
	//M�thode pour se d�connecter
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
	
	//M�thode pour �x�cuter une requete SQL
		protected PreparedStatement prepare(String query, boolean generatedKeys) throws SQLException {
			if (generatedKeys) {
				return this.connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);			
			}
			
			return this.prepare(query);
		}
	//On cr�� ici la m�thode map SANS LA REMPLIR pour forcer les classes filles � l'utiliser
	//avec une g�n�ricit� pour l'utiliser avec n'importe quel objet
	protected abstract T map(ResultSet result);
}
