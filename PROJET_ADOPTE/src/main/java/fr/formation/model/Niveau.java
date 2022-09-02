package fr.formation.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Niveau {
	@Enumerated(EnumType.ORDINAL)
	DEBUTANT,INTERMEDIAIRE,AVANCE;
}
