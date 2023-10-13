package com.epicode.Spring.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.model.User;
import com.epicode.Spring.repository.UserDAORepository;
import com.epicode.Spring.service.UserService;

@Component
public class UserRunner implements CommandLineRunner {
	
	@Autowired UserService userservice;
	
	Logger log = LoggerFactory.getLogger(UserRunner.class);
	
	// Accedere direttamente alla repository dal runner non è completamente corretto
	// anche se lo possso fare e funzionerebbe 
	//@Autowired UserDAORepository repo;

	@Override
	public void run(String... args) throws Exception {
		 
		System.out.println("UserRunner... ");
		
		//User admin = userservice.createAdminUser();
		//User fake = userservice.createFakeUser();
		//User custom = userservice.createCustomUser("Giuseppe", "Verdi", "Napoli", 49, "g.verdi@example.com", "123456789");
		
		//log.info(admin.toString());
		//log.info(fake.toString());
		//log.info(custom.toString());
		
		// metodi per salvare un utente nel db
		// userservice.createUser(admin);
		// userservice.createUser(fake);
		// userservice.createUser(custom);
		
		// metodi per leggere utenti dal db
		//List<User> userlist = userservice.findAllUser();
		//userlist.forEach(u -> System.out.println(u));
		
		User p1 = userservice.findUser(2);
		User p2 = userservice.findUser(3);
		//System.out.println(p);
		//p1.setCity("Palermo");
		//p1.setEmail("patrizio.dr@yahoo.com");
		
		// metodo per modificare un utente nel DB
		//userservice.updateUser(p1);
		
		// metodo per cancellare un utente nel DB
		//userservice.removeUser(p2);
	
	}

	
	
}
