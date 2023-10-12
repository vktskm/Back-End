package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Editore;
import entities.Libro;

public class EditoreDao {
   
	private final EntityManager em;

	public EditoreDao(EntityManager em) {
		this.em = em;
	}
	
	public void save( Editore ed) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(ed);
		transaction.commit(); 
	}
	
	public void removeFromISBN(long isbn) {
		Editore foundPubblicazione = em.find(Editore.class, isbn);
		if(foundPubblicazione != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(foundPubblicazione);
			transaction.commit();
			System.out.println("Pubblicazione" + isbn + "eliminata da database");
		}else {
			System.out.println("Could not delete a non-existent pubblicazione");
		}
	}
	
	public Editore searchByISBN(Long isbn){
		Query q = em.createNamedQuery("searchByISBN");
		q.setParameter("isbn", isbn);
		return (Editore) q.getSingleResult();
	}
	
	public List<Editore> searchByYear(Integer annoPubblicazione) {
		Query query = em.createNamedQuery("searchByYear");
		query.setParameter("annoPubblicazione", annoPubblicazione);
		return query.getResultList();
	}
	
	public List <Editore> searchByTitle(String titolo) {
		Query query = em.createNamedQuery("searchByTitle");
		query.setParameter("titolo", titolo);
		return (List<Editore>) query.getResultList();
	}
	
	public List<Libro> searchByAuthor(String autore) {
		Query query = em.createNamedQuery("searchByAuthor");
		query.setParameter("autore", autore);
		return query.getResultList();
	}
}
	

