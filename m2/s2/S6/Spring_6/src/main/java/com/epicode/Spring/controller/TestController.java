package com.epicode.Spring.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.model.User;

//@Controller // -> serve per richiamare template html
@RestController // -> serve per restituire una response di tipo String senza l'obbligo di mettere @ResponseBody in ogni endpoint
@RequestMapping("/api") // -> definisce un uri di base per tutti gli endpoint
public class TestController {
	
	@GetMapping("/test")
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Author", "Marioi Rosii");
		
		ResponseEntity<String> resp;
		if(true) { // metto un controllo
			resp = new ResponseEntity<String>("getTest", headers, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("Errore!!!!", headers, HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	
	@GetMapping("/test/{id}")
	public String getTestByID() {
		return "getTestByID";
	}
	
	@PostMapping("/test")
	@ResponseStatus(HttpStatus.CREATED)
	public String postTest(@RequestBody User obj) {
		System.out.println(obj);
		return "postTest";
	}
	
	@PutMapping("/test")
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String putTest() {
		return "putTest";
	}
	
	@DeleteMapping("/test")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String deleteTest() {
		return "deleteTest";
	}

}
