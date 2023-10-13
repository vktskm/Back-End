package com.example.gestione_prenotazioni.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gestione_prenotazioni.classes.Edificio;
import com.example.gestione_prenotazioni.classes.TipoPostazione;
import com.example.gestione_prenotazioni.services.EdificioService;
import com.example.gestione_prenotazioni.services.PostazioneService;
import com.example.gestione_prenotazioni.services.PrenotazioneService;
import com.example.gestione_prenotazioni.services.UserService;

@Component
public class PrenotazioniRun implements CommandLineRunner {

	@Autowired EdificioService ed;
	@Autowired PostazioneService ps;
	@Autowired PrenotazioneService pt;
	@Autowired UserService us;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Crea Edifici
		System.out.println("\n\n\n ");
		System.out.println(" -------------------- Creazione Edifici -------------------- ");
		ed.creaEdificio("U4","Via Bicocca","Milano");
		ed.creaEdificio("Pirellone","Piazza Garibaldi","Milano");
		ed.creaEdificio("Torre Unicredit","Piazza Gae Aulenti","Milano");
		ed.creaEdificio("Ubs","Via Bellinzona","Lugano");
	    ed.creaEdificio("Swiss Post","Piazza Indipendenza","Chiasso");
	    
	    //Funzionano tutti i metodi
		//System.out.println( ed.findByIdEdificio(3));
		//ed.findAllEdificio();
		//ed.deleteEdificio(4);
	    
	    //Crea Postazioni
	    System.out.println("\n\n\n ");
		System.out.println(" -------------------- Creazione Postazioni -------------------- ");
		ps.creaPostazione("Aula Magna ", TipoPostazione.SALA_RIUNIONI, 10, 1);
		ps.creaPostazione("Sala riunioni", TipoPostazione.SALA_RIUNIONI, 50, 3);
		ps.creaPostazione("Aula Magna", TipoPostazione.SALA_RIUNIONI, 10, 4);
		ps.creaPostazione("Giardino", TipoPostazione.OPENSPACE, 20, 3);
		ps.creaPostazione("Villa", TipoPostazione.OPENSPACE, 20, 2);
		ps.creaPostazione("Cortile", TipoPostazione.OPENSPACE, 30, 1);
		ps.creaPostazione("Sala Jolly", TipoPostazione.PRIVATO, 5, 1);
		ps.creaPostazione("Sala Planet", TipoPostazione.PRIVATO, 5, 1);
		ps.creaPostazione("Sala Red", TipoPostazione.PRIVATO, 5, 1);
		ps.creaPostazione("Sala Apple", TipoPostazione.PRIVATO, 5, 2);
		
		
		//CREA UTENTI
		System.out.println("\n\n\n ");
		System.out.println(" -------------------- Creazione User -------------------- ");
		us.creaUser("Angelo", "Schembri","angeloschembri@gmail.com","trbdjusk");
		us.creaUser("Marco", "Lanza","marcolanza@gmail.com","t6w6yhek");
		us.creaUser("Riccardo", "Scibetta","riccardoscibetta@gmail.com","f45tysts");
		us.creaUser("Giulia", "Lai","giulialai@gmail.com","g4k6uwju");
		us.creaUser("Aurora", "Caico","auroracaico@gmail.com","q45dhge4");
		us.creaUser("Francesca", "Cardella","francescacardella@gmail.com","gts4x5ju");
		us.creaUser("Giulia", "Costa","giuliacosta@gmail.com","q4wsh9e4");
	

        //CREA PRENOTAZIONI 
		System.out.println("\n\n\n ");
		System.out.println(" -------------------- Creazione Prenotazioni -------------------- ");
    	pt.creaPrenotazione(1, 10, LocalDate.of(2023, 9, 14));
    	pt.creaPrenotazione(1, 10, LocalDate.of(2023, 9, 14));
		pt.creaPrenotazione(3, 10, LocalDate.of(2023, 9, 14));
		pt.creaPrenotazione(4, 10, LocalDate.of(2023, 9, 14));
		pt.creaPrenotazione(2, 10, LocalDate.of(2023, 9, 14));
		pt.creaPrenotazione(6, 10, LocalDate.of(2023, 9, 14));
		pt.creaPrenotazione(7, 10, LocalDate.of(2023, 9, 14));
		pt.creaPrenotazione(5, 2, LocalDate.of(2023, 8, 2));
		pt.creaPrenotazione(4, 2, LocalDate.of(2023, 8, 2));
		
		
		System.out.println("\n\n\n ");
		System.out.println(" -------------------- Cerca Postazioni -------------------- ");
		ps.findByCityEdificio(TipoPostazione.SALA_RIUNIONI, "Milano");
		ps.findByCityEdificio(TipoPostazione.SALA_RIUNIONI, "Roma");//Non esiste
		
	}
	
}
