package com.example.gestione_prenotazioni.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.gestione_prenotazioni.classes.Edificio;
import com.example.gestione_prenotazioni.classes.Postazione;
import com.example.gestione_prenotazioni.classes.TipoPostazione;
import com.example.gestione_prenotazioni.repository.EdificioDao;
import com.example.gestione_prenotazioni.repository.PostazioneDao;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Service
public class PostazioneService {
  
Logger log = LoggerFactory.getLogger( PostazioneService.class);
    
    @Autowired EdificioService svcEd;
	@Autowired PostazioneDao repoPt;
	@Autowired @Qualifier("postazione") private ObjectProvider<Postazione> postazioneProvider;

	
    public Postazione creaPostazione( String descrizione, TipoPostazione tipo , Integer numeroMassimoOccup , int id ){
    	Postazione p = postazioneProvider.getObject();
    	p.setDescrizione(descrizione);
    	p.setTipo(tipo);;
    	p.setNumeroMassimoOccup(numeroMassimoOccup);
    	p.setEdificio(svcEd.findByIdEdificio(id));
    	repoPt.save(p);
    	log.info( p.toString()+ " save Database. ");
    	return p;
    } 	
    
    public List<Postazione> findByCityEdificio(TipoPostazione tipo, String city) {
        List<Postazione> res = repoPt.findByTipoAndCityEdificio(tipo, city);
        if(res.size() == 0) {
            log.info("La postazione cercata non esiste in questo DataBase");
            return null;
        }else {
            res.forEach(p -> log.info(p.toString()));
            return res;
        }

    }
    
    
    public Postazione findByIdPostazione(Integer id) {
          return repoPt.findById(id).get();    	
    }
    
    public void findAllPostazione() {
    	repoPt.findAll().forEach(p -> System.out.println(p));
    }
    
    public void deletePostazione(int id) {
        repoPt.delete(findByIdPostazione(id));
   }
    
    
}
