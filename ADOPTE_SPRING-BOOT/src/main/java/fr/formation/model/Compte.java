package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//	@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 5)
@MappedSuperclass
public abstract class Compte implements UserDetails {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name = "all_id")
//	@JsonView(JsonViews.Common.class)
//	private int id;

	@Column(name = "all_pseudo", length = 100, nullable = false, unique = true)
	@JsonView(JsonViews.Common.class)
	private String username;

	@Column(name = "all_mdp", length = 255, nullable = false)
	@JsonView(JsonViews.Common.class)
	private String password;
	// si on a besoin de validation sur le mot de passe on doit ajouter un attribut
	// transcient
	@Transient
	// ^:debut de chaine
	// $:fin de chaine
	// .:1 caractere quelconque
	// {4,20}:repetition du caractere precedent 4 à 20 fois
	// (?=autreregexp) contrainte supplementaire sur la chaine
	// *:repetition du caractere precedent 0 à n fois
	// (?=.*[a-z]): un minuscule dans la chaine
	@Pattern(message = "il faut une majuscule, une minuscule, un chiffre et un caractere special(*.?!@#+=)", regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[*.?!@#+=]).{4,20}$")
	private String mdp;

	public Compte() {

	}

	public Compte(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
