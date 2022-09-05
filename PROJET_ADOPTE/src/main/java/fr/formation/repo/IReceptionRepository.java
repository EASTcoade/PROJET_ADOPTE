package fr.formation.repo;

import java.util.List;

import fr.formation.model.Reception;

public interface IReceptionRepository extends IRepository<Reception,Integer>{
	public List<Reception> findByIdDest(Integer id);
}
