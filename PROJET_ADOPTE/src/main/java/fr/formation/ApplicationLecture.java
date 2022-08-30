package fr.formation;

import fr.formation.exception.IdNegativeException;
import fr.formation.exception.ItemNotFoundException;
import fr.formation.exception.SonNotFoundException;
import fr.formation.model.Son;
import fr.formation.model.Utilisateur;
import fr.formation.service.SonService;
import fr.formation.service.UtilisateurService;

public class ApplicationLecture {
	private static UtilisateurService srvUti = new UtilisateurService();
	private static SonService srvSon = new SonService();
	
	public static void main(String[] args) {
		
		findAllUtilisateur();
//		findUtilisateurById();
		
		
//		findAllSon();	
//		findSonById();
		
	}
	public static void findAllUtilisateur() {
		for(Utilisateur u : srvUti.findAll()) {
			System.out.println(u.getId()+" : "+u.getNom());
		}
	}
	public static void findUtilisateurById() {
		Utilisateur u=null;
		try {
			u = srvUti.findById(1);
		} catch (IdNegativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u.getId()+" : "+u.getNom());
	}
	public static void findAllSon() {
		for(Son s : srvSon.findAll()) {
			System.out.println(s.getTitre()+"."+s.getFormat().name()+" importé par l'utilisateur id = "+s.getCreateur().getId()+" : "+s.getCreateur().getNom());
		}
	}
	public static void findSonById() {
		Son s=null;
		try {
			s = srvSon.findById(3);
		} catch (IdNegativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SonNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.getTitre()+"."+s.getFormat().name()+" importé par l'utilisateur id = "+s.getCreateur().getId()+" : "+s.getCreateur().getNom());
	}
}
