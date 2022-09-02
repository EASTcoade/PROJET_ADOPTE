package fr.formation.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum FormatSon {
	@Enumerated(EnumType.ORDINAL)
	MP3,WAV;
}
