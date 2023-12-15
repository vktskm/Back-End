package com.epicode.Spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.model.User;

@RestController
@RequestMapping("/api/be")
public class MicroservizioProducer {
	
	// Controller di endpoint invocati da un altro microservizio
	
	@GetMapping("/txt")
	public String testTxt() {
		return "BE String Content";
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> testUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Mario", "Rossi", "Roma"));
		users.add(new User("Giuseppe", "Verdi", "Milano"));
		users.add(new User("Francesca", "Neri", "Napoli"));
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
