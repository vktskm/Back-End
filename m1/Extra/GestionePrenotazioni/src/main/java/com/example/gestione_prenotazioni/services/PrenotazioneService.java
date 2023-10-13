package com.example.gestione_prenotazioni.services;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.gestione_prenotazioni.classes.Edificio;
import com.example.gestione_prenotazioni.classes.Postazione;
import com.example.gestione_prenotazioni.classes.Prenotazione;
import com.example.gestione_prenotazioni.classes.TipoPostazione;
import com.example.gestione_prenotazioni.classes.User;
import com.example.gestione_prenotazioni.repository.PostazioneDao;
import com.example.gestione_prenotazioni.repository.PrenotazioneDao;

import jakarta.persistence.ManyToOne;

@Service
public class PrenotazioneService {
  
	
    Logger log = LoggerFactory.getLogger( PrenotazioneService.class);
    
    @Autowired PostazioneService svcPs;
    @Autowired UserService svcUs;
	@Autowired PrenotazioneDao repoPr;
	@Autowired @Qualifier("prenotazione") private ObjectProvider<Prenotazione> prenotazioneProvider;

	
		
    public Prenotazione creaPrenotazione( int idUs, int idPost , LocalDate dataPrenotata ){
    	
    //Il primo if controlla se l'utente ha prenotato in quella data 
    if(repoPr.findByUserAndDataPrenotata(svcUs.findByIdUser(idUs), dataPrenotata) == null) {
		
    	//Il secondo if confronta il numero di postazioni libere con il numero massimo di postazioni consentito, se è disponibile un posto libero effettua la prenotazione
    	if(repoPr.findByPostazioneAndDataPrenotata(svcPs.findByIdPostazione(idPost), dataPrenotata).size() < svcPs.findByIdPostazione(idPost).getNumeroMassimoOccup()) 
		{
    	   Prenotazione p = prenotazioneProvider.getObject();
    	   p.setUser(svcUs.findByIdUser(idUs));
    	   p.setPostazione(svcPs.findByIdPostazione(idPost));
           p.setDataPrenotata(dataPrenotata);
    	   repoPr.save(p);
    	   log.info( p.toString() + " save Database. ");
    	   return p;
			
		}//fine secondo if
    	else {
    	        log.info("\n La sala è piena in questo giorno.");
 				return null;
    	     }
    	     
    	}//fine primo if
    	else {
    		log.info("\n Hai gia' prenotato in questa data.");
			return null;
    	}
    	
    } 	
    
    public Prenotazione findByIdPrenotazione(Integer id) {
          return repoPr.findById(id).get();    	
    }
    
    public void findAllPrenotazione() {
    	repoPr.findAll().forEach(p -> System.out.println(p));
    }
    
    public void deletePrenotazione( Prenotazione pr) {
        repoPr.delete(pr);
   }
}
