package app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EditoreDao;
import dao.PrestitoDao;
import dao.UtenteDao;
import entities.Editore;
import entities.Libro;
import entities.Periodicita;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;
import utils.JpaUtil;


public class Archivio {
	
private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
public static void main(String[] args) {
	
	EntityManager em = emf.createEntityManager();
	
	EditoreDao ed = new EditoreDao(em);
	UtenteDao ud = new UtenteDao(em);
	PrestitoDao pd = new PrestitoDao(em);	
	
	//********** CREAZIONE LIBRI **********

    Libro libro1 = new Libro("Adrenalina", 2019, 548, "Ibrahimovic", "Autobiografico");
    Libro libro2 = new Libro("Maradona", 2020, 300, "Gianni Mina'", "Scienza");
	Libro libro3 = new Libro("Il capo dei capi", 2006, 1200, "Attilio Bolzoni", "Fiction");
	Libro libro4 = new Libro("Montalbano", 2001, 328, "Andrea Camilleri", "Drammatico");
	Libro libro5 = new Libro("Metamorfosi", 1893, 318, "Kafka", "Psicologia");
	Libro libro6 = new Libro("La Grangela ", 2023, 400, "Angelo Schembri", "Archelogia");
			
	//********** CREAZIONE RIVISTE **********
	Rivista rivista1 = new Rivista("Focus", 1992, 150, Periodicita.MENSILE);
	Rivista rivista2 = new Rivista("Calcio 2000", 1992, 250, Periodicita.MENSILE);
	Rivista rivista3 = new Rivista("TIME", 1923, 100, Periodicita.SETTIMANALE);
	Rivista rivista4 = new Rivista("Bild",1980,50, Periodicita.MENSILE);                 
	Rivista rivista5 = new Rivista("Zeitung ", 1931, 900, Periodicita.SEMESTRALE);

	//********** CREAZIONE UTENTI **********
	
	Utente utente1 = new Utente("Andrea", "San Tommaso", LocalDate.of(2002, 6, 06));
	Utente utente2 = new Utente("Vincenzo", "Schembri", LocalDate.of(1989, 6, 06));
	Utente utente3 = new Utente("Riccardo", "Scibetta", LocalDate.of(1985, 12, 27));
			
	//********** CREAZIONE PRESTITI **********
			
	Prestito prestito1 = new Prestito(utente1, rivista2, LocalDate.now(), LocalDate.now(), null);
	Prestito prestito2 = new Prestito(utente1, libro2, LocalDate.of(2023, 03, 01), LocalDate.of(2023, 03, 01), LocalDate.of(2023, 03, 27));
	Prestito prestito3 = new Prestito(utente3, libro5, LocalDate.of(2023, 01, 07), LocalDate.of(2023, 01, 07), LocalDate.of(2023, 02, 12));
	Prestito prestito4 = new Prestito(utente1, rivista3, LocalDate.now(), LocalDate.now(), null);
	Prestito prestito5 = new Prestito(utente2, libro1, LocalDate.of(2022, 10, 12), LocalDate.of(2022, 10, 12), null);
	/*
    ed.save(libro1);
	ed.save(libro2);
	ed.save(libro3);
    ed.save(libro4);
    ed.save(libro5);
    ed.save(libro6);
   
    ed.save(rivista1);
    ed.save(rivista2);
	ed.save(rivista3);
	ed.save(rivista4);
	ed.save(rivista5);
	
	
	ud.save(utente1);
    ud.save(utente2);
	ud.save(utente3);
	
	pd.save(prestito1);	
	pd.save(prestito2);
	pd.save(prestito3);
	pd.save(prestito4);
	pd.save(prestito5);
	*/
	// ********** ELIMINAZIONA DA DATABASE PER ISBN **********
	
    // ed.removeFromISBN(4);
	
	// ********** RICERCA PER ISBN **********
	//Editore a = ed.searchByISBN(8L);
	//System.out.println(a);
	//System.out.println("Il libro cercato per ISBN è: " + ed.searchByISBN(8L));
	
	// ********** RICERCA PER AUTORE **********
	//List<Libro> listaAutore = ed.searchByAuthor("Andrea Camilleri");
	//listaAutore.forEach( a -> System.out.println(a));
	
	// ********** RICERCA PER ANNO PUBBLICAZIONE **********
	//List<Editore> listaAnno = ed.searchByYear(2019);
	//listaAnno.forEach( a -> System.out.println(a));
	//System.out.println("Il libro cercato per ANNO è: " + ed.searchByYear(2023).toString());
	
	// ********** RICERCA PER TITOLO **********
	//List<Editore> listaTitolo = ed.searchByTitle("Maradona");
    //listaTitolo.forEach( a -> System.out.println(a));
    //("Il libro cercato per TITOLO è: " + ed.searchByTitle("montagne").toString());
	
	
	// ********** Ricerca degli elementi attualmente in prestito dato un numero di tessera utente **********
	//List<Editore> listaPrestito = pd.getActiveByCode(1);
    //listaPrestito.forEach( a -> System.out.println(a));
	
	
	// ********** Ricerca di tutti i prestiti scaduti e non ancora restituiti **********
	List<Editore> listaScad = pd.getLateActive();
    listaScad.forEach( a -> System.out.println(a));
	
	
	em.close();
	emf.close();
   

	
   }// fine del main

}//fine classe Archivio