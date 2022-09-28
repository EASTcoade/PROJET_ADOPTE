package fr.formation.service;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.SonNotFoundException;
import fr.formation.model.FormatSon;
import fr.formation.model.Son;
import fr.formation.repo.ISonRepository;

@Service
public class SonService {
	
	@Autowired
	ISonRepository repoSon;
	
	public Optional<Son> findById(int id) throws IdNegativeException, SonNotFoundException {
		
		//verif de l'ID
		if(id<=0) {
			throw new IdNegativeException();
		}
		
		//V�rif du son
		Optional<Son> leSon = repoSon.findById(id);
		if(leSon==null) {
			throw new SonNotFoundException();
		}
		
		//on retourne le son trouv�
		return leSon;
	}
	public List<Son> findAll(){
		
		List<Son> listeSon=repoSon.findAll();
		if(listeSon==null) {
			return new ArrayList<>();
		}
		return listeSon;
	}
	public void save(Son son) throws NotValidException {
		if (son.getTitre() == null || son.getTitre().isBlank()) {
			throw new NotValidException();
		}
		
		if (son.getContenu() == null) {
			throw new NotValidException();
		}	
		
		repoSon.save(son);
	}
	
	public void deleteById(int id) throws IdNegativeException {
		
		if (id <= 0) {
			throw new IdNegativeException();
		}
		this.repoSon.deleteById(id);
	}
	
	//analyse de l'extension du fichier
	public Optional<String> findExtensionFichier(String chemin){
		return Optional.ofNullable(chemin)
			.filter(f -> f.contains("."))
	        .map(f -> f.substring(chemin.lastIndexOf(".") + 1));
	}
	//determination si format acceptable
	public boolean formatAcceptable(String chemin) {
		String formatFichier = this.findExtensionFichier(chemin).get().toString().toUpperCase();
		FormatSon[] formats = FormatSon.values();
		for(FormatSon format : formats) {
			if (formatFichier.equals(format.name())){
				return true;
			}
		}
		return false;
	}
	//d�termination du format du fichier
	public FormatSon formatFichier(String chemin) {
		String formatFichier = this.findExtensionFichier(chemin).get().toString().toUpperCase();
		FormatSon[] formats = FormatSon.values();
		for(FormatSon format : formats) {
			if(formatFichier.equals(format.name())) {
				return format;
			}
		}
		return null;
	}
	public String getFileContent(String son) {
		Path path = Path.of(son);
		
		try {
			String contenu = Files.readString(path);
			return contenu;
		}
		
		catch (AccessDeniedException e) {
			return "Accès refusé";
		}
		
		catch (NoSuchFileException e) {
			return "Fichier non trouvé";
		}
		
		catch (IOException e) {
			// Peut être intéressant à garder en "mode débug"
//			e.printStackTrace(); // permet d'imprimer toute la trace d'erreur
			return "Autre erreur de lecture / écriture";
		}
	}
}
