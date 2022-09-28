package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reception")
public class Reception {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rec_id")
	protected int id;
	
	@ManyToOne
	@JoinColumn(name="rec_cha_id")
	protected Chat chat;
	
	@ManyToOne
	@JoinColumn(name="rec_uti_id_dest")
	protected Utilisateur destinataire;

	@Column(name="rec_lu")
	protected boolean Lu;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Utilisateur getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}

	public boolean isLu() {
		return Lu;
	}

	public void setLu(boolean lu) {
		Lu = lu;
	}
	
	
}
