package com.epicode.introSpring.Configuration.config_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// File di configurazione che mi permette di definire i bean della classe test
@Configuration
public class ConfigurationTest {
	
	// Crea un bean di tipo Test con il valore "Ciao Mondo"
	@Bean
	@Scope("singleton") // restituisco sempre la stessa istanza della classe test
	public Test test() {
		return new Test("Ciao Mondo");
	}
	
	// Crea un bean di tipo Test con il valore che passo tramite parametro
	@Bean
	@Scope("prototype") 
	public Test testParam(String txt) {
		return new Test(txt);
	}

}
