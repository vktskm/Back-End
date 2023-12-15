package com.epicode.Spring.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.model.Contact;
import com.epicode.Spring.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired ContactRepository contactRepo;
	@Autowired @Qualifier("fakeContactBean") private ObjectProvider<Contact> contactProvider;

	public void createFakeContact() {
		Contact c = contactProvider.getObject();
		contactRepo.save(c);
	}
	
	public List<Contact> getAllContacts() {
		return (List<Contact>) contactRepo.findAll();
	}
	
	public Contact getContactsByID(Long id) {
		return contactRepo.findById(id).get();
	}
	

}
