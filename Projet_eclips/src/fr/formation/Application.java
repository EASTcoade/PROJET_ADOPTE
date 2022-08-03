package fr.formation;

import java.util.ArrayList;
import java.util.Scanner;

import fr.formation.model.Admin;
import fr.formation.model.Instrument;
import fr.formation.model.Niveau;
import fr.formation.model.Son;
import fr.formation.model.StyleMusical;
import fr.formation.model.Utilisateur;


public class Application {

	public static void main(String[] args) {
		// création d'utilisateurs
		Utilisateur bernard = new Utilisateur();
		Utilisateur bianca = new Utilisateur();
		Admin grandchef = new Admin();

		// création de styles musicaux
		StyleMusical jazz = new StyleMusical();
		jazz.setNom("Jazz");
		StyleMusical pop = new StyleMusical();
		pop.setNom("Pop");

		// création d'instruments
		Instrument trompette = new Instrument();
		trompette.setNom("Trompette");
		Instrument guitare = new Instrument();
		guitare.setNom("Guitare");

		// création de sons
		Son demo1 = new Son();
		demo1.setTitre("Demo1");
		Son demo2 = new Son();
		demo2.setTitre("Demo2");
		Son demo3 = new Son();
		demo3.setTitre("Demo3");

		// initialisation des utilisateurs
		bernard.setNom("DUPUIS");
		bernard.setPrenom("Bernard");
		bernard.setPseudo("Guitaristedu65");
		bernard.setAge(99);
		bernard.setAdresse("33 rue des Batignoles");
		bernard.setMail("bernard.dupuis@gmail.com");
		bernard.setMdp("Beber_542");
		bernard.setNiveau(Niveau.INTERMEDIAIRE);
		bernard.setTelephone("0612233445");

		// init Admin
		grandchef.setNom("jeancharles");

		ArrayList<Utilisateur> userlist = new ArrayList<>();
		userlist.add(bernard);

//		bernard.setPhotoprofil(null);
		ArrayList<StyleMusical> styledebernard = new ArrayList<>();
		styledebernard.add(jazz);
		ArrayList<Instrument> instrumentsdebernard = new ArrayList<>();
		instrumentsdebernard.add(trompette);
		ArrayList<Son> sondebernard = new ArrayList<>();
		sondebernard.add(demo1);

		bianca.setNom("MARTIN");
		bianca.setPrenom("Bianca");
		bianca.setPseudo("Bibi-la-sauvage");
		bianca.setAge(82);
		bianca.setAdresse("50 rue des Marais");
		bianca.setMail("bianca.martin@gmail.com");
		bianca.setMdp("123456");
		bianca.setNiveau(Niveau.DEBUTANT);
		bianca.setTelephone("0625729955");
//		bernard.setPhotoprofil(null);
		ArrayList<StyleMusical> styledebianca = new ArrayList<>();
		styledebianca.add(jazz);
		ArrayList<Instrument> instrumentsdebianca = new ArrayList<>();
		instrumentsdebianca.add(guitare);
		ArrayList<Son> sondebianca = new ArrayList<>();
		sondebianca.add(demo2);
		sondebianca.add(demo3);
		match(bianca, bernard);
		
		
		grandchef.annoncer("bienvenue");
		
		
		
		
		
	}

	static String read() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static void match(Utilisateur expediteur, Utilisateur destinataire) {
		System.out.println(expediteur.getPseudo() + "vous à envoyé une demande d'ami, acceptez vous ?");
		System.out.println("taper oui ou non");
		String n;
		do {
			n = read();
			if (n.equals("oui")) {
				System.out.println("vous avez matcher");
				return;
			} else if (n.equals("non")) {
				System.out.println("vous n'avez pas matcher (dur)");
				return;
			} else {
				System.out.println("resaisir");

			}
		} while (n != "oui" || n != "non");

	}

}
