package com.epicode.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.model.Contact;
import com.epicode.Spring.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
	
	@Autowired ContactService contactService;
	
	@GetMapping
	public ResponseEntity<List<Contact>> getAll() {
		List<Contact> listaContatti = contactService.getAllContacts();
		ResponseEntity<List<Contact>> resp = new ResponseEntity<List<Contact>>(listaContatti, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {
		// Gestione tramite un Handler delle eccezioni
		Contact c = contactService.getContactsByID(id);
		return new ResponseEntity<Contact>(c, HttpStatus.OK);
		
		// Gestione manuale delle eccezioni
//		try {
//			Contact c = contactService.getContactsByID(id);
//			return new ResponseEntity<Contact>(c, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}
	
	@PostMapping
	public ResponseEntity<?> createContact(@RequestBody Contact contact) {
		Contact c = contactService.createContact(contact);
		return new ResponseEntity<Contact>(c, HttpStatus.CREATED);
		
//		try {
//			Contact c = contactService.createContact(contact);
//			return new ResponseEntity<Contact>(c, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
		Contact c = contactService.updateContact(id, contact);
		return new ResponseEntity<Contact>(c, HttpStatus.OK);
		
		// Gestione manuale delle eccezioni		
//		try {
//			Contact c = contactService.updateContact(id, contact);
//			return new ResponseEntity<Contact>(c, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeContact(@PathVariable Long id) {
		String msg = contactService.removeContactByID(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
		// Gestione manuale delle eccezioni	
//		try {
//			String msg = contactService.removeContactByID(id);
//			return new ResponseEntity<String>(msg, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}

}
