package com.example.gestione_prenotazioni.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.gestione_prenotazioni.classes.User;

@Configuration
@PropertySource("classpath:application.properties")
public class UserConfiguration {
	
	@Bean("user")
	@Scope("prototype")
	public User user() {
		return new User();
	}
}
