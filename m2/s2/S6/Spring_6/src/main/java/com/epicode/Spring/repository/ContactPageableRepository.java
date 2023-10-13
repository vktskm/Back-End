package com.epicode.Spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epicode.Spring.model.Contact;

@Repository
public interface ContactPageableRepository extends PagingAndSortingRepository<Contact, Long> {

	
	
}
