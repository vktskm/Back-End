package com.epicode.Spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class MicroservizioConsumer {
	
	// Controller con endpoint invocati dal client
	
	@GetMapping("/txt")
	public String test() {
		// Oggetto in grado di effetture richieste ad API lato server
		RestTemplate rt = new RestTemplate();
		// URL del microservizio che fornisce il dato
		String rtUrl = "http://localhost:8081/api/be/txt";
		// chiamata al microservizio che fornisce il dato
		// getForEntity(URL del microservizio, TIPO DI DATO CHE MI ASPETTO COME RITORNO)
		ResponseEntity<String> response = rt.getForEntity(rtUrl, String.class);
		return "Public Content: " + response.getBody() ;
	}
	
	@GetMapping("/users")
	public Object users() {
		// Oggetto in grado di effetture richieste ad API lato server
		RestTemplate rt = new RestTemplate();
		// URL del microservizio che fornisce il dato
		String rtUrl = "http://localhost:8081/api/be/users";
		// Leggo dal microservizio lato BE una lista di Users
		Object response = rt.getForObject(rtUrl, Object.class);
		System.out.println(response);
		// La stampo in JSON per il client
		return response;
	}

}
