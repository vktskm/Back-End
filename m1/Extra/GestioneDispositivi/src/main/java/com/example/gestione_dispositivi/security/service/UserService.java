package com.example.gestione_dispositivi.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestione_dispositivi.security.entity.User;
import com.example.gestione_dispositivi.security.repository.UserRepository;

@Service
public class UserService {
	
	Logger log = LoggerFactory.getLogger(DispositivoService.class);
	
	@Autowired UserRepository repo;
	
	
	public User findById(long id){
		
		User us = repo.findById(id).get();
		log.info(us.toString());
		return us;
	}
	
	public List<User> findAll(){
		List<User> listaUser = (List<User>)repo.findAll();
		listaUser.forEach(l -> log.info(l.toString()));
		return listaUser;
	}
	

}
