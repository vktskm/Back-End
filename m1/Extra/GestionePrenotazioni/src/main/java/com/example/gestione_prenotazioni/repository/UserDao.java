package com.example.gestione_prenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.gestione_prenotazioni.classes.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

}
