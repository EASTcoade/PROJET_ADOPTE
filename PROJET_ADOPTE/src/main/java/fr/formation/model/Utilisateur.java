package fr.formation.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uti_id")
	private int id;
	
	@Column(name = "uti_date")
	private LocalDate dateNaissance;
	
	@Column(name = "uti_pseudo", length = 150, nullable = false)
	private String pseudo;
	@Column(name = "uti_nom", length = 150, nullable = false)
	private String nom;
	@Column(name = "uti_prenom", length = 150, nullable = false)
	private String prenom;
	@Column(name = "uti_mail", length = 150, nullable = false)
	private String mail;
	@Column(name = "uti_mdp", length = 150, nullable = false)
	private String mdp;
	@Column(name = "uti_adresse", length = 150, nullable = false)
	private String adresse;
	@Column(name = "uti_tel", length = 20)
	private String telephone;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "uti_niveau_id", nullable = false)
	private Niveau niveau;
	
	@ManyToOne
	@JoinColumn(name = "uti_image_id", nullable = false)
	private Image photoprofil;
	
	@Column(name = "uti_age")
	private int age;
	
	
	@ManyToMany
	@JoinTable (name ="style_utilisateur",
	joinColumns=@JoinColumn(name="stluti_utilisateur_id"),
	inverseJoinColumns=@JoinColumn(name="stluti_stylemusical_id"))
	private List<StyleMusical> stylemusical;
	
	@ManyToMany
	@JoinTable (name ="utilisateur_instrument",
	joinColumns=@JoinColumn(name="utiins_utilisateur_id"),
	inverseJoinColumns=@JoinColumn(name="utiins_instrument_id"))
	private List<Instrument> listeinstrument;
	

	
	@OneToMany(mappedBy ="createur")
	private List<Son> son; // à voir avec Jérémy

	
	
	
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Image getPhotoprofil() {
		return photoprofil;
	}

	public void setPhotoprofil(Image photoprofil) {
		this.photoprofil = photoprofil;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<StyleMusical> getStylemusical() {
		return stylemusical;
	}

	public void setStylemusical(List<StyleMusical> stylemusical) {
		this.stylemusical = stylemusical;
	}

	public List<Instrument> getListeinstrument() {
		return listeinstrument;
	}

	public void setListeinstrument(List<Instrument> listeinstruments) {
		this.listeinstrument = listeinstruments;
	}

	public List<Son> getSon() {
		return son;
	}

	public void setSon(List<Son> son) {
		this.son = son;
	}

	public boolean friendWith(Utilisateur people, Leader chef) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
