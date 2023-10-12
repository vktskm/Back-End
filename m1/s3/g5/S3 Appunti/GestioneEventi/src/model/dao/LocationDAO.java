package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Location;
import util.JpaUtil;

public class LocationDAO {
	private static final Logger logger = LoggerFactory.getLogger(LocationDAO.class);

	public void save(Location object) {
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

	public void refresh(Location object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(object);
		} finally {
			em.close();
		}

	}

	public Location getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Location.class, id);
		} finally {
			em.close();
		}

	}

	public void delete(Location object) {
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
