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
import fr.formation.exception.ImageNotFoundException;
import fr.formation.exception.NotValidException;
import fr.formation.model.Image;
import fr.formation.repo.IImageRepository;

@Service
public class ImageService {
	
	@Autowired
	IImageRepository repoImage;
	
	public Optional<Image> findById(int id) throws IdNegativeException, ImageNotFoundException {
		
		//verif de l'ID
		if(id<=0) {
			throw new IdNegativeException();
		}
		
		//V�rif du son
		Optional<Image> lImage = repoImage.findById(id);
		if(lImage==null) {
			throw new ImageNotFoundException();
		}
		
		//on retourne le son trouv�
		return lImage;
	}
	public List<Image> findAll(){
		
		List<Image> listeImage =repoImage.findAll();
		if(listeImage==null) {
			return new ArrayList<>();
		}
		return listeImage;
	}
	public void save(Image image) throws NotValidException {
		if (image.getTitre() == null || image.getTitre().isBlank()) {
			throw new NotValidException();
		}
		
		if (image.getContenu() == null) {
			throw new NotValidException();
		}	
		
		repoImage.save(image);
	}
	public String getFileContent(String image) {
		Path path = Path.of(image);
		
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

