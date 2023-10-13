package com.epicode.Spring.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.Spring.model.Contact;
import com.epicode.Spring.repository.ContactPageableRepository;
import com.epicode.Spring.repository.ContactRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {
	
	@Autowired ContactRepository contactRepo;
	@Autowired ContactPageableRepository contactPageableRepo;
	@Autowired @Qualifier("fakeContactBean") private ObjectProvider<Contact> contactProvider;

	public void createFakeContact() {
		Contact c = contactProvider.getObject();
		contactRepo.save(c);
	}
	
	// Metodo getAll che utilizza il repository CrudRepository
	public List<Contact> getAllContacts() {
		return (List<Contact>) contactRepo.findAll();
	}
	
	// Metodo getAll che utilizza il repository PagingAndSortingRepository
	public Page<Contact> getAllContactsPageable(Pageable pageable) {
		return contactPageableRepo.findAll(pageable);
	}
	
	public Contact getContactsByID(Long id) {
		if(!contactRepo.existsById(id)) {
			throw new EntityNotFoundException("Contact not exists!!!");
		}
		return contactRepo.findById(id).get();
	}
	
	public Contact createContact(Contact contact) {
		if(contactRepo.existsByEmail(contact.getEmail())) {
			throw new EntityExistsException("Contact email exists!!!");
		}
		return  contactRepo.save(contact);
	}
	
	public Contact updateContact(Long id, Contact contact) {
		if(!contactRepo.existsById(id)) {
			throw new EntityNotFoundException("Contact not exists!!!");
		}
		if(id != contact.getId()) {
			throw new EntityNotFoundException("Id and ContactID do not match!");
		}
		return  contactRepo.save(contact);
		
		
//		Contact c = getContactsByID(id);
//		if(c.getId() == contact.getId()) {
//			return  contactRepo.save(contact);
//		}
//		throw new Exception("Id and contact do not match");
	}
	
	public String removeContactByID(Long id) {
		if(!contactRepo.existsById(id)) {
			throw new EntityNotFoundException("Contact not exists!!!");
		}
		Contact c = getContactsByID(id);
		contactRepo.delete(c);
		return "Contact deleted!!!";
	}

}
