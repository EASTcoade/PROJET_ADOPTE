package fr.formation;

import java.util.HashMap;
import java.util.Map;

import fr.formation.repo.sql.SqlConnection;

public class ApplicationJpa {
public static void main(String[] args) {
	
	Map<String, String> props = new HashMap<>();
	props.put("hibernate.connection.password", SqlConnection.password);
	
}
	
	
	
}
