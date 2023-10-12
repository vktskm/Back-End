package com.epicode.controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.enumerated.Type;
import com.epicode.model.Smartphone;
import com.epicode.model.Utente;

public class MainProject {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("Lezione_13");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		try {
			Smartphone sm = new Smartphone("Apple", "IPhone");
			Utente u1 = new Utente("Mario", "Rossi", 41, "m.rossi@example.com", sm, Type.USER);
			
			Smartphone sm2 = new Smartphone("Samsung", "Galaxy");
			Utente u2 = new Utente("Giuseppe", "Verdi", 29, "g.verdi@example.com", sm2, Type.USER);
			
			//inserisciUtente(u2);
			
			Utente u = leggiDettaglioUtente(1);
			System.out.println(u);
			System.out.println(u.getSmartphone().getMarca());
			
			Smartphone s = leggiDettaglioSmartphone(1);
			System.out.println(s);
			System.out.println(s.getUtente().getNome());
			
			//cancellaUtente(u);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static void inserisciUtente(Utente u) throws SQLException {
		em.getTransaction().begin(); // Apri un collegamento con il DB
		em.persist(u); // INSERT
		em.getTransaction().commit(); // Esegui l'istruzione
		System.out.println(u);
		//System.out.println(u.getNome() + " " + u.getCognome() + " created!!!");
	}
	
	public static Utente leggiDettaglioUtente(long id) throws SQLException {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, id); // SELECT By ID
		em.getTransaction().commit();
		return u;
	}
	
	public static Smartphone leggiDettaglioSmartphone(long id) throws SQLException {
		em.getTransaction().begin();
		Smartphone s = em.find(Smartphone.class, id); // SELECT By ID
		em.getTransaction().commit();
		return s;
	}
	
	public static void cancellaUtente(Utente u) throws SQLException {
		em.getTransaction().begin();
		em.remove(u); // DELETE
		em.getTransaction().commit();
		System.out.println(u.getNome() + " " + u.getCognome() + " deleted!!!");
	}

}
