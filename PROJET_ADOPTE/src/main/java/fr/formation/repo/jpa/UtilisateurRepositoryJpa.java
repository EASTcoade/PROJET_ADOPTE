package fr.formation.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;



public  class UtilisateurRepositoryJpa extends AbstractRepositoryJpa<Utilisateur> implements IUtilisateurRepository {
	public UtilisateurRepositoryJpa() {
		super(Utilisateur.class);
		// TODO Auto-generated constructor stub
	}

//	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EshopUnit");
	

	@Override
	public Utilisateur findByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em	.createQuery("select p from Utilisateur p where p.nom = ?1", Utilisateur.class)
						.setParameter(1, nom)
						.getSingleResult();
		}
		
		catch (Exception e) {
			return null;
		}
		
		finally {
			em.close();
		}
	}
}



