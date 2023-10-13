package com.build.energy.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.build.energy.security.entity.Indirizzo;
import com.build.energy.security.pageable.repository.IndirizzoPageable;
import com.build.energy.security.repository.IndirizzoRepository;

@Service
public class IndirizzoService {
	
	private Logger log = LoggerFactory.getLogger(ClienteService.class);

	@Autowired IndirizzoRepository repo;
	@Autowired IndirizzoPageable page;
	
	@Autowired ComuneService comuneSvc;
	
	@Autowired @Qualifier("indirizzo") private ObjectProvider<Indirizzo> provider;
	
	// SAVE METHODS
	public Indirizzo addIndirizzo(String via,
								Integer civico,
								String localita,
								Integer cap,
								Long idComune) {
		
		Indirizzo i = provider.getObject().builder()
						.via(via)
						.civico(civico)
						.localita(localita)
						.cap(cap)
						.comune(comuneSvc.findById(idComune))
						.build();
				repo.save(i);
				System.out.println();
				log.info("Indirizzo aggiunto al Database, Id: " + i.getId());
				return i;
	}
	
	// FIND METHODS
	public Indirizzo findById(long id) {
		Indirizzo i = repo.findById(id).get();
		log.info(i.toString());
		return i;
	}
	
	public List<Indirizzo> findAll(){
		List<Indirizzo> l = (List<Indirizzo>)repo.findAll();
		l.forEach(i -> log.info(i.toString()));
		return l;
	}
	
	// PAGEABLE METHODS
	public Page<Indirizzo> getAll(Pageable pageable) {
		return page.findAll(pageable);
	}
		
	// OTHER METHODS
	public void caricaIndirizzi() {
		// TODO Auto-generated method stub
		addIndirizzo("Via Dante" , 13 , "Fondachello", 43572 , 1l );
		addIndirizzo("Via Mazzini" , 126 , "Playa", 43452 , 2l );
		addIndirizzo("Piazza Cavour" , 12 , "Marina", 23972 , 3l );
		addIndirizzo("Corso Umberto" , 3 , "San Paolo", 42372 , 4l );
	}


}
