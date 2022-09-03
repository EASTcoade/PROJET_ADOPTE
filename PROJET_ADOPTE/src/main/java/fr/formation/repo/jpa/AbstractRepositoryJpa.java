package fr.formation.repo.jpa;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.repo.sql.SqlConnection;



public class AbstractRepositoryJpa<T> {
protected static EntityManagerFactory emf = null;
	
	private Class<T> clz;
	private String entityName;
	
	public AbstractRepositoryJpa(Class<T> clz) {
		if (emf == null) {
			// On peut modifier une ou plusieurs propri�t�s avant de g�n�rer l'EntityManagerFactory
			Map<String, String> props = new HashMap<>();
			props.put("hibernate.connection.password", SqlConnection.password);
			
			emf = Persistence.createEntityManagerFactory("EshopUnit",props);
			
		}
		
		this.clz = clz;
		this.entityName = clz.getSimpleName();
	}
	
	public List<T> findAll() {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em
					.createQuery("select e from "+entityName+" e", clz)
					.getResultList();
		}
		
		catch (Exception e) {
			return null;
		}
		
		finally {
			em.close();
		}
	}
	
	public T findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(clz, id);
		}
		
		catch (Exception e) {
			return null;
		}
		
		finally {
			em.close();
		}
	}
	
	public void save(T entity) {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Field field = entity.getClass().getDeclaredField("id");
			field.setAccessible(true);
			Integer id = (Integer)field.get(entity);
			
			if (id == 0) {
				em.persist(entity);
			}
			
			else {
				em.merge(entity);
			}
			
			em.getTransaction().commit();
		}
		
		catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
//			throw new CantPersistException(e.getMessage()); //exception � cr�er ?
		}
		
		finally {
			em.close();
		}
	}

	public void deleteById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em	.createQuery("delete from " + entityName + " e where e.id = ?1")
				.setParameter(1, id)
				.executeUpdate();
			
			em.getTransaction().commit();
		}
		
		catch (Exception e) {
			em.getTransaction().rollback();
//			throw new CantDeleteException(e.getMessage()); //exception � cr�er ?
		}
		
		finally {
			em.close();
		}
	}
	
	// Permet de fermer l'EMF depuis l'application, à la fin de l'application par exemple
	public static void close() {
		if (emf != null) {
			emf.close();
		}
	}
}
