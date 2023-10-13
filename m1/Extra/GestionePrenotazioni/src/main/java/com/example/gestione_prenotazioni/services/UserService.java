package com.example.gestione_prenotazioni.services;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.example.gestione_prenotazioni.classes.User;
import com.example.gestione_prenotazioni.repository.UserDao;

@Service
public class UserService {
	
    Logger log = LoggerFactory.getLogger( UserService.class);
    
	@Autowired UserDao repoUs;
	@Autowired @Qualifier("user") private ObjectProvider<User> userProvider;

		
    public User creaUser( String name , String lastName , String email, String password ){
    	User u = userProvider.getObject();
    	u.setName(name);
    	u.setLastName(lastName);
    	u.setEmail(email);
    	u.setPassword(password);
    	repoUs.save(u);
    	log.info( u.toString() + " save Database. ");
    	return u;
    } 	
    
    public User findByIdUser(Integer id) {
          return repoUs.findById(id).get();    	
    }
    
    public void findAllUser() {
    	repoUs.findAll().forEach(u -> System.out.println(u));
    }
    
    public void deletUser( User us) {
        repoUs.delete(us);
   }
	
}
