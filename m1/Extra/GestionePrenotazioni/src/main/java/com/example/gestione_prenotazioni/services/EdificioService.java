package com.example.gestione_prenotazioni.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.gestione_prenotazioni.classes.Edificio;
import com.example.gestione_prenotazioni.repository.EdificioDao;


@Service
public class EdificioService {
	
	Logger log = LoggerFactory.getLogger(EdificioService.class);
    
	@Autowired EdificioDao repoEd;
	@Autowired @Qualifier("edificio") private ObjectProvider<Edificio> edificioProvider;
    
    public Edificio creaEdificio( String name, String address, String city){
    	Edificio e = edificioProvider.getObject();
    	e.setName(name);
    	e.setAddress(address);
    	e.setCity(city);
    	repoEd.save(e);
    	log.info( e.toString()+ "  save Database. ");
    	return e;
    } 	
    
    public Edificio findByIdEdificio(Integer id) {
          return repoEd.findById(id).get();    	
    }
    
    public void findAllEdificio() {
    	repoEd.findAll().forEach(e -> System.out.println(e));
    }
    
    public void deleteEdificio(int id) {
        repoEd.delete(findByIdEdificio(id));
   }

}