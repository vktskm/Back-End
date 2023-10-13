package com.example.gestione_prenotazioni.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.gestione_prenotazioni.classes.Edificio;


@Configuration
@PropertySource("classpath:application.properties")
public class EdificioConfiguration {
	
	@Bean("edificio")
	@Scope("prototype")
	public Edificio edificio() {
		return new Edificio();
	}
}
