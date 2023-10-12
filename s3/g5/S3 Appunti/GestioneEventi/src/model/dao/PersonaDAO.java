package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Persona;
import util.JpaUtil;

public class PersonaDAO {
	private static final Logger logger = LoggerFactory.getLogger(PersonaDAO.class);

	public void save(Persona object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.getTransaction().begin();
			em.persist(object);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	public void refresh(Persona object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(object);
		} finally {
			em.close();
		}

	}

	public Persona getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Persona.class, id);
		} finally {
			em.close();
		}

	}

	public void delete(Persona object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(object);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

}
