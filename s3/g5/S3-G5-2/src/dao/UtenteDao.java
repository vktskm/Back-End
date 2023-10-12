package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Editore;
import entities.Utente;

public class UtenteDao {
	
	private final EntityManager em;
	

	public UtenteDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void save( Utente u) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(u);
		transaction.commit(); 
		System.out.println("Utente Salvato");
	}

}
