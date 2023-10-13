package com.example.gestione_dispositivi.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.gestione_dispositivi.security.entity.Dispositivo;
import com.example.gestione_dispositivi.security.entity.Laptop;
import com.example.gestione_dispositivi.security.entity.Smartphone;
import com.example.gestione_dispositivi.security.entity.Stato;
import com.example.gestione_dispositivi.security.entity.Tablet;
import com.example.gestione_dispositivi.security.entity.User;
import com.example.gestione_dispositivi.security.repository.DispositivoDao;

@Service
public class DispositivoService {
    
	
	Logger log = LoggerFactory.getLogger(DispositivoService.class);
	
	@Autowired  DispositivoDao repo  ;
	@Autowired @Qualifier("smartphone") private ObjectProvider<Smartphone> smartphoneProvider;
	@Autowired @Qualifier("laptop") private ObjectProvider<Laptop> laptopProvider;
	@Autowired @Qualifier("tablet") private ObjectProvider<Tablet> tabletProvider;
	
	
	public Dispositivo creaDispositivo( Dispositivo d){
		
		if( d instanceof Smartphone) {
			Smartphone s = smartphoneProvider.getObject();
			repo.save(s);
			log.info(s.toString() + "save Database");
			return s;
		}else  if( d instanceof Laptop) {
			Laptop l = laptopProvider.getObject();
			repo.save(l);
			log.info(l.toString() + "save Database");
			return l;
		}else if( d instanceof Tablet) {
			Tablet t = tabletProvider.getObject();
			repo.save(t);
			log.info(t.toString() + "save Database");
			return t;
		}else {
		  
			return null;
		}
	}
	
	public void updateDispositivo(long id, User utente, Stato stato) {
        Dispositivo d = findByDispositivo(id);
        d.setUser(utente);
        d.setStato(stato);
        repo.save(d);
    }
	
	public Dispositivo findByDispositivo(long id){
		return repo.findById(id).get();
	}
	
	public List<Dispositivo> findAll(){
    	return (List<Dispositivo>) repo.findAll();
    }
	
    public void findAllDispositivo() {
    	repo.findAll().forEach(u -> System.out.println(u));
    }
    
   public void deletUser( Dispositivo d) {
        repo.delete(d);
   }

}
