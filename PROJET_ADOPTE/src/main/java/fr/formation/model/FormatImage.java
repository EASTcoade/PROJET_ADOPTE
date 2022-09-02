package fr.formation.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum FormatImage {
	@Enumerated(EnumType.ORDINAL)
	JPEG,JPG,PNG,GIF;

	int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
