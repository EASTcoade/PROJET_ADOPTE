package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public enum StyleMusical {
	@Enumerated(EnumType.ORDINAL)
	ROCK,POP,ELECTRO,CLASSIQUE,JAZZ,METAL,RAP,REGGAE;
}
	


