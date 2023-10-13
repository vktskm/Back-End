package com.epicode.Spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.epicode.Spring.model.Contact;
import com.epicode.Spring.repository.ContactRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class ContactControllerTest {

	@Autowired TestRestTemplate restTemplate;
	@Autowired ContactRepository repo;
	@Autowired @Qualifier("contactBean") ObjectProvider<Contact> contactTest;

	@Test
	@DisplayName("Cerco con successo un Contatto con uno specifico id")
	void testSuccessGetByID() {
		Contact c = contactTest.getObject();
		c.setName("Mario");
		c.setLastname("Rossi");
		c.setCity("Roma");
		c.setAge(22);
		c.setEmail("m.rossi@example.com");
		c.setPassword("qwerty");
		repo.save(c);
		
		System.out.println(c);
		
		String url = "http://localhost:8080/api/contacts/" + c.getId();
		ResponseEntity<Contact> resp = restTemplate.getForEntity(url, Contact.class);
		
		Contact testContact = resp.getBody();
		HttpStatusCode code = resp.getStatusCode();
		
		System.out.println(testContact);
		System.out.println(code);
		
		assertThat(code).isEqualTo(HttpStatus.OK);
		assertThat(testContact.getId()).isEqualTo(c.getId());
		
		
	}
	
	@Test
	@DisplayName("Cerco con un errore un Contatto con un id errato")
	void testNotFoundGetByID() {
				
		String url = "http://localhost:8080/api/contacts/999" ;
		ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
		
		String testError = resp.getBody();
		HttpStatusCode code = resp.getStatusCode();
		
		System.out.println(testError);
		System.out.println(code);
		
		assertThat(code).isEqualTo(HttpStatus.NOT_FOUND);
		
	}

//	@Test
//	@Disabled
//	void testCreateContact() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testUpdateContact() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testRemoveContact() {
//		fail("Not yet implemented");
//	}

}
