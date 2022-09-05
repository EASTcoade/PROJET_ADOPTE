package fr.formation.service;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.ImageNotFoundException;
import fr.formation.model.Image;
import fr.formation.repo.IImageRepository;
import fr.formation.repo.sql.ImageRepositorySql;

public class ImageService {
//	public Image findById(int id) throws IdNegativeException, ImageNotFoundException {
//		IImageRepository repoImage = new ImageRepositorySql();
//		
//		//verif de l'ID
//		if(id<=0) {
//			throw new IdNegativeException();
//		}
//		
//		//V�rif du son
//		Image lImage = repoImage.findById(id);
//		if(lImage==null) {
//			throw new ImageNotFoundException();
//		}
//		
//		//on retourne le son trouv�
//		return lImage;
//	}
//	public List<Image> findAll(){
//		IImageRepository repoImage=new ImageRepositorySql();
//		
//		List<Image> listeImage =repoImage.findAll();
//		if(listeImage==null) {
//			return new ArrayList<>();
//		}
//		return listeImage;
//	}
//	public void save(Image images) throws NotValidException {
//		IImageRepository repoImage=new ImageRepositorySql();
//		if (images.getTitre() == null || images.getTitre().isBlank()) {
//			throw new NotValidException();
//		}
//		
//		if (images.getContenu() == null) {
//			throw new NotValidException();
//		}	
//		
//		repoImage.save(images);
//	}
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

