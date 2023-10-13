package com.epicode.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.model.Contact;
import com.epicode.Spring.service.ContactService;

@RestController
@RequestMapping("/api/contacts/pageable")
public class ContactPageableController {
	
	@Autowired ContactService contactService;
	
	@GetMapping
	public ResponseEntity<Page<Contact>> getAll(Pageable pageable) {
		// http://localhost:8080/api/contacts/pageable?page=0&size=10&sort=age,ASC
		// ?page=0&size=10&sort=age,ASC -> sono i parametri che saranno contenuti nell'ogg di tipo Pageable
		Page<Contact> listaContatti = contactService.getAllContactsPageable(pageable);
		ResponseEntity<Page<Contact>> resp = new ResponseEntity<Page<Contact>>(listaContatti, HttpStatus.OK);
		return resp;
	}

}
