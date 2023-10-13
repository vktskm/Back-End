package com.epicode.Spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.model.User;
import com.epicode.Spring.services.UserService;

@Component
public class UserRunner implements CommandLineRunner {
	
	// Soluzione di Inject del Service su Proprietà
	@Autowired private UserService us;

	// Soluzione di Inject del Service su Costruttore
//	private UserService us;
//	@Autowired
//	public UserRunner(UserService us) {
//		super();
//		this.us = us;
//	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Run...");
		
		User admin = us.createAdminUser();
		User custom = us.createCustomUser("Giuseppe", "Verdi", "Milano", 22, "g.verdi@example.com", "12345");
		User fake = us.createFakeUser();
		
		us.addUserList(custom);
		us.addUserList(admin);
		us.addUserList(fake);
		
		us.getUserList();
		
	}

}
