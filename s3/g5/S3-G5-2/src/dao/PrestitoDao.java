package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Editore;
import entities.Prestito;

public class PrestitoDao {
   
	private final EntityManager em;

	public PrestitoDao(EntityManager em) {
		this.em = em;
	}
	
	public void save(Prestito p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit(); 
		System.out.println("Prestito salvato!");
	}
	
	public List< Editore> getActiveByCode( Integer cartaId) {
		Query query = em.createNamedQuery("findActiveByCode");
		query.setParameter("cartaId", cartaId);
		return query.getResultList();
	}
	
	public List<Editore> getLateActive(){
		Query query = em.createNamedQuery("findLateActive");
		return query.getResultList();
	}
	
	
}
