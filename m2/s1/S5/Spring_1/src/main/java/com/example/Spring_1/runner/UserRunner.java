package com.example.Spring_1.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.example.Spring_1.configuration.UserConfiguration;
import com.example.Spring_1.model.User;

@Component
public class UserRunner implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(UserRunner.class);
	
	// Definisco una classe @Component che implementa l'interfccia CommandLineRunner
	// Questa interfacci mi chiede di definire un metodo run che verrà invocato
	// in maniera automatica dalla nostra applicazione Spring.

	@Override
	public void run(String... args) throws Exception {
		log.info("User run...");
		System.out.println("User run...");
		configBean();
	}
	
	public void configBean() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(UserConfiguration.class);
		
		// Creo un bean sfruttando il metodo customUser() definito nella classe UserConfiguration
		User u1 =  (User) appContext.getBean("customUser");
		u1.setName("Mario");
		u1.setLastname("Rossi");
		u1.setCity("Roma");
		u1.setEmail("m.rossi@example.com");
		u1.setPassword("qwerty");
		System.out.println(u1);
		
		// Creo un bean sfruttando il metodo newUser() definito nella classe UserConfiguration
		User u2 =  (User) appContext.getBean("newUser", "Giuseppe", "Verdi", "Milano", "g.verdi@example.com", "123456789");
		System.out.println(u2);
		
		// Creo un bean sfruttando il metodo adminUser() definito nella classe UserConfiguration
		User u3 =  (User) appContext.getBean("adminUser");
		System.out.println(u3);
		
		appContext.close();
	}

}
