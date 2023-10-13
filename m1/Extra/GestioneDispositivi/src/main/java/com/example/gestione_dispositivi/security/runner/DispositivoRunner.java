package com.example.gestione_dispositivi.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gestione_dispositivi.security.entity.Dispositivo;
import com.example.gestione_dispositivi.security.entity.Laptop;
import com.example.gestione_dispositivi.security.entity.Smartphone;
import com.example.gestione_dispositivi.security.entity.Stato;
import com.example.gestione_dispositivi.security.entity.Tablet;
import com.example.gestione_dispositivi.security.entity.User;
import com.example.gestione_dispositivi.security.service.DispositivoService;
import com.example.gestione_dispositivi.security.service.UserService;

@Component
public class DispositivoRunner implements CommandLineRunner {

	@Autowired DispositivoService ds;
	@Autowired UserService us;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Umberto devo consegnare venerdi alle 17 che domani ho un matrimonio fuori citta' */
		
		
		//Creo 
//		ds.creaDispositivo(new Smartphone());
//		ds.creaDispositivo(new Smartphone());
//		ds.creaDispositivo(new Tablet());
//		ds.creaDispositivo(new Tablet());
//		ds.creaDispositivo(new Laptop());
//		ds.creaDispositivo(new Laptop());
	
		User us1 =  us.findById(1);
		System.out.println(us1);
		ds.updateDispositivo( 1, us1, Stato.DISMESSO);
		Dispositivo d1 = ds.findByDispositivo(1);
		System.out.println(d1);
		
		User us2 =  us.findById(2);
		System.out.println(us2);
		ds.updateDispositivo( 2, us2, Stato.MANUTENZIONE);
		Dispositivo d2 = ds.findByDispositivo(2);
		System.out.println(d2);
		
		User us3 =  us.findById(3);
		System.out.println(us1);
		ds.updateDispositivo( 3, us3, Stato.DISMESSO);
		Dispositivo d3 = ds.findByDispositivo(3);
		System.out.println(d3);
		
		
		
		
		
	}
        
	
}
