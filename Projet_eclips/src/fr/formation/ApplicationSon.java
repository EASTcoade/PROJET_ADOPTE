package fr.formation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import fr.formation.model.Son;
import fr.formation.model.Utilisateur;
import fr.formation.service.SonService;

public class ApplicationSon {

	public static void main(String[] args) {
		
		//enregistrement d'un son en BDD
//		try {
//			File f = new File(
//					"C:\\Users\\Rémi\\Downloads\\monti_cardasclassical__wpanufnik__preview.mp3");
//		
//			byte[] bytesFromFile = Files.readAllBytes(f.toPath());
//			
//			SonService srvSon = new SonService();
//			Son leSon = new Son();
//			
//			leSon.setContenu(bytesFromFile);
//			leSon.setTitre("First song");
//			leSon.setCreateur(new Utilisateur());
//			leSon.getCreateur().setId(1);
//			
//			srvSon.save(leSon);
//			System.out.println("Son enregitsré en BDD");
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
		
		//re-création d'un mp3 à partir du son stocké en BDD
		
		try {
			SonService srvSon = new SonService();
			Son leSon = new Son();
			
			leSon=srvSon.findById(2);
			
			byte[] bytesFromBdd = leSon.getContenu();
			String chemin = "C:/Users/Rémi/Desktop/firstsong.mp3";
//			Path path = Path.of(chemin);
			
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
