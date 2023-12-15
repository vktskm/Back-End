package com.epicode.Spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.Spring.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
