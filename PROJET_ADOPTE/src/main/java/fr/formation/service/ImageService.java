package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.NotValidException;
import fr.formation.exception.ImageNotFoundException;
import fr.formation.model.Image;
import fr.formation.repo.IImageRepository;
import fr.formation.repo.ISonRepository;
import fr.formation.repo.sql.ImageRepositorySql;
import fr.formation.repo.sql.SonRepositorySql;

public class ImageService {
	public Image findById(int id) throws IdNegativeException, ImageNotFoundException {
		IImageRepository repoImage = new ImageRepositorySql();
		
		//verif de l'ID
		if(id<=0) {
			throw new IdNegativeException();
		}
		
		//V�rif du son
		Image lImage = repoImage.findById(id);
		if(lImage==null) {
			throw new ImageNotFoundException();
		}
		
		//on retourne le son trouv�
		return lImage;
	}
	public List<Image> findAll(){
		IImageRepository repoImage=new ImageRepositorySql();
		
		List<Image> listeImage =repoImage.findAll();
		if(listeImage==null) {
			return new ArrayList<>();
		}
		return listeImage;
	}
	public void save(Image images) throws NotValidException {
		IImageRepository repoImage=new ImageRepositorySql();
		if (images.getTitre() == null || images.getTitre().isBlank()) {
			throw new NotValidException();
		}
		
		if (images.getContenu() == null) {
			throw new NotValidException();
		}	
		
		repoImage.save(images);
	}

}
