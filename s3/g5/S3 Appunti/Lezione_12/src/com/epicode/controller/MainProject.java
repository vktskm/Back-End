package com.epicode.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.model.Type;
import com.epicode.model.Utente;

public class MainProject {

	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("paramsDb");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		
		
		try {
			//Utente u1 = new Utente("Mario", "Rossi", 25, "m.rossi@example.com", Type.USER);
			//Utente u2 = new Utente("Giuseppe", "Verdi", 41, "g.verdi@example.com", Type.MODERATOR);
			//Utente u3 = new Utente("Francesca", "Neri", 36, "f.neri@example.com", Type.ADMIN);
			
			//inserisciUtente(u2);
			
			Utente u = leggiDettaglioUtente(1);
			System.out.println(u);
			
			//u.setType(Type.ADMIN);
			
			//System.out.println(u);
			//em.refresh(u);
			//modificaUtente(u);
			
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
	
	public static void modificaUtente(Utente u) throws SQLException {
		em.getTransaction().begin();
		em.merge(u); // UPDATE
		em.getTransaction().commit();
		System.out.println(u.getNome() + " " + u.getCognome() + " modified!!!");
	}
	
	public static void cancellaUtente(Utente u) throws SQLException {
		em.getTransaction().begin();
		em.remove(u); // DELETE
		em.getTransaction().commit();
		System.out.println(u.getNome() + " " + u.getCognome() + " deleted!!!");
	}

	public static Utente leggiDettaglioUtente(long id) throws SQLException {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, id); // SELECT By ID
		em.getTransaction().commit();
		return u;
	}
	
	public static List<Utente> leggiUtenti() throws SQLException {
		
		return null;
	}

}
