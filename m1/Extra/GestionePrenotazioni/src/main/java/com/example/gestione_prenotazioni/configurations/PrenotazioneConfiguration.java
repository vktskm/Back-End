package com.example.gestione_prenotazioni.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.gestione_prenotazioni.classes.Prenotazione;

@Configuration
@PropertySource("classpath:application.properties")
public class PrenotazioneConfiguration {
   
	@Bean("prenotazione")
	@Scope("prototype")
	public Prenotazione prenotazione() {
		return new Prenotazione();
	}
	
}
