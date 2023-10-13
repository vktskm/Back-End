package com.example.gestione_prenotazioni.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.gestione_prenotazioni.classes.Postazione;

@Configuration
@PropertySource("classpath:application.properties")
public class PostazioneConfiguration {
    
	@Bean("postazione")
	@Scope("prototype")
	public Postazione postazione() {
		return new Postazione();
	}
}
