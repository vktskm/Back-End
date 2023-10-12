package com.epicode.jdbc;

import java.sql.SQLException;
import java.util.List;

public class MainProject {

	public static void main(String[] args) {
		
		try {
			// Creo una connessione al DB
			DbConnection db = new DbConnection();
			
			// Creo un oggetto di tipo Utente
			//Utente u = new Utente("Mario", "Rossi", 25, "m.rossi@example.com");
			//Utente g = new Utente("Giuseppe", "Verdi", 41, "g.verdi@example.com");
			//Utente f = new Utente("Francesca", "Neri", 33, "f.neri@example.com");
			// Lo salvo nel DB
			//db.inserisciUtente(f);
			
			//Utente utente = db.leggiDettaglioUtente(1); // leggo un utente nel DB con un id specifico
			//System.out.println(utente);
			
			// Modifico qualcosa dell'ogg letto
			//utente.setAnni(99);
			//Salvo nel DB le modifiche fatte
			//db.modificaUtente(utente);
			
			// rimuovo un ogg dal DB
			//db.cancellaUtente(utente);
			
			// leggo tutti gli ogg presenti nel db e li inserisco in una lista
			List<Utente> lista = db.leggiUtenti();
			lista.forEach(ut -> System.out.println(ut));
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}

	}

}
