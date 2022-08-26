package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.SonNotFoundException;
import fr.formation.model.Son;
import fr.formation.model.Utilisateur;
import fr.formation.repo.ISonRepository;  
import fr.formation.repo.sql.SonRepositorySql;

public class SonService {
	public Son findById(int id) throws IdNegativeException, SonNotFoundException {
		ISonRepository repoSon = new SonRepositorySql();
		
		//verif de l'ID
		if(id<=0) {
			throw new IdNegativeException();
		}
		
		//Vérif du son
		Son leSon = repoSon.findById(id);
		if(leSon==null) {
			throw new SonNotFoundException();
		}
		
		//on retourne le son trouvé
		return leSon;
	}
	public List<Son> findAll(){
		ISonRepository repoSon=new SonRepositorySql();
		
		List<Son> listeSon=repoSon.findAll();
		if(listeSon==null) {
			return new ArrayList<>();
		}
		return listeSon;
	}
	public void save(Son son) throws NotValidException {
		ISonRepository repoSon=new SonRepositorySql();
		if (son.getTitre() == null || son.getTitre().isBlank()) {
			throw new NotValidException();
		}
		
		if (son.getContenu() == null) {
			throw new NotValidException();
		}	
		
		repoSon.save(son);
	}
}
