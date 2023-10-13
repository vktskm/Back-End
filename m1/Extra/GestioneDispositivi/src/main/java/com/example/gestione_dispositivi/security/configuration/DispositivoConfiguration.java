package com.example.gestione_dispositivi.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.gestione_dispositivi.security.entity.Laptop;
import com.example.gestione_dispositivi.security.entity.Smartphone;
import com.example.gestione_dispositivi.security.entity.Tablet;

@Configuration
@PropertySource("classpath:application.properties")
public class DispositivoConfiguration {
	
	
	@Bean("smartphone")
	@Scope("prototype")
	public Smartphone smartphone( ) {
		return new Smartphone();
	}
	
	@Bean("tablet")
	@Scope("prototype")
	public Tablet tablet( ) {
		return new Tablet();
	}
	
	@Bean("laptop")
	@Scope("prototype")
	public Laptop laptop( ) {
		return new Laptop();
	}

}
