package fr.formation.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;




@Entity
@Table(name="utilisateur")
public class Utilisateur extends Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uti_id")
	@JsonView(JsonViews.Common.class)
	private int id;
	
	@Column(name = "uti_date_naissance",nullable=false)
	@JsonView(JsonViews.Common.class)
	private LocalDate dateNaissance;
//	@Column(name = "uti_pseudo", length = 100, nullable = false)
//	@JsonView(JsonViews.Common.class)
//	private String pseudo;

	@Column(name = "uti_nom", length = 100, nullable = false)
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Column(name = "uti_prenom", length = 100, nullable = false)
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@Column(name = "uti_mail", length = 150, nullable = true)
	@JsonView(JsonViews.Common.class)
	private String mail;

	@Column(name = "uti_adresse", length = 100, nullable = false)
	@JsonView(JsonViews.Common.class)
	private String adresse;
	@Column(name = "uti_tel", length = 20,nullable=false)
	@JsonView(JsonViews.Common.class)
	private String telephone;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "uti_niveau", nullable = false)
	@JsonView(JsonViews.Common.class)
	private Niveau niveau;
	
	@JsonIgnore
	@ManyToOne//(fetchtype.lazy)
	@JoinColumn(name = "uti_image_id")


	@JsonView(JsonViews.Common.class)
	private Image photoProfil;
	
	public Utilisateur(String username, String password, String nom, String prenom, 
			String mail, String adresse, String telephone, Niveau niveau,LocalDate dateNaissance) {
		super(username,password);
		this.nom=nom;
		this.prenom=prenom;
		this.mail=mail;
		this.adresse=adresse;
		this.telephone=telephone;
		this.niveau=niveau;
		this.dateNaissance=dateNaissance;		
	}
	public Utilisateur() {
		
	}

	//pas besoin d'attribut �ge puisqu'on a la date de naissance
//	@Column(name = "uti_age")
//	private int age;
	
//	@JsonIgnore
	@ManyToMany (cascade = CascadeType.PERSIST)
	@JoinTable (name ="style_utilisateur",
	joinColumns=@JoinColumn(name="styuti_utilisateur_id"),
	inverseJoinColumns=@JoinColumn(name="styuti_stylemusical_id"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonView({JsonViews.UtilisateurAvecStyle.class,
		JsonViews.UtilisateurAvecTout.class})
	private Set<StyleMusical> stylemusical;
	
//	@JsonIgnore
	@ManyToMany (cascade = CascadeType.PERSIST)
	@JoinTable (name ="utilisateur_instrument",
	joinColumns=@JoinColumn(name="utiins_utilisateur_id"),
	inverseJoinColumns=@JoinColumn(name="utiins_instrument_id"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonView({JsonViews.UtilisateurAvecInstrument.class,
			JsonViews.UtilisateurAvecTout.class})
	private Set<Instrument> listeinstrument;
	

//	@JsonIgnore
	@OneToMany(mappedBy ="createur")
	@JsonView({JsonViews.UtilisateurAvecSon.class,
			JsonViews.UtilisateurAvecTout.class})
	private List<Son> son; // à voir avec Jérémy

	
	
	
//	public String getPseudo() {
//		return pseudo;
//	}
//
//	public void setPseudo(String pseudo) {
//		this.pseudo = pseudo;
//	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
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
		return photoProfil;
	}

	public void setPhotoprofil(Image photoProfil) {
		this.photoProfil = photoProfil;
	}

	public Set<StyleMusical> getStylemusical() {
		return stylemusical;
	}

	public void setStylemusical(Set<StyleMusical> stylemusical) {
		this.stylemusical = stylemusical;
	}

	public Set<Instrument> getListeinstrument() {
		return listeinstrument;
	}

	public void setListeinstrument(Set<Instrument> listeinstruments) {
		this.listeinstrument = listeinstruments;
	}

	public List<Son> getSon() {
		return son;
	}

	public void setSon(List<Son> son) {
		this.son = son;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean friendWith(Utilisateur people, Utilisateur chef) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
