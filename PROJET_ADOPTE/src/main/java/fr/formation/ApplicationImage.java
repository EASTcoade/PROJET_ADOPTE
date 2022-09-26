package fr.formation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import fr.formation.model.FormatImage;
import fr.formation.model.reception;
import fr.formation.model.Son;
import fr.formation.service.ImageService;
import fr.formation.service.SonService;



public class ApplicationImage {
public static void main(String[] args) {
		
		//enregistrement d'une image en png/jpg/gif...
//		try {
//			File f = new File("D:\\coding\\guitare.jpg");
//		
//			byte[] bytesFromFile = Files.readAllBytes(f.toPath());
//			
//			ImageService srvImage = new ImageService();
//			Image lImage = new Image();
//			
//			lImage.setContenu(bytesFromFile);
//			lImage.setTitre("premiere image");
//			lImage.setFormat(FormatImage.JPG);
//			
//			srvImage.save(lImage);
//			System.out.println("Image enregitsr� en jpg");
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
		
//		//re-cr�ation d'une image � partir image stocké sur base de donnée
		
		try {
			ImageService srvImage = new ImageService();
			reception limage = new reception();
			
			limage=srvImage.findById(1);
			
			byte[] bytesFromBdd = limage.getContenu();
			String chemin = "D:/coding/stock-bdd/guitare2.jpg";

			
			File f = new File(chemin);
			
			OutputStream os = new FileOutputStream(f);
			 
            // Starting writing the bytes in it
            os.write(bytesFromBdd);
 
            // Display message on console for successful
            // execution
            System.out.println("bytes convertis");
 
            // Close the file connections
            os.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
}
}
