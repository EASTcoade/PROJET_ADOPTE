package fr.formation.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import fr.formation.model.Reception;
import fr.formation.repo.IReceptionRepository;

public class ReceptionRepositoryJpa extends AbstractRepositoryJpa<Reception> implements IReceptionRepository{

	public ReceptionRepositoryJpa() {
		super(Reception.class);
	}
	
	@Override
	public List<Reception> findByIdDest(Integer id) {
		EntityManager em=emf.createEntityManager();
		try {
			return em.createQuery("SELECT r from Reception r where r.destinataire.id=?1", Reception.class)
			.setParameter(1, id)
			.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
		}
	}
	
}
