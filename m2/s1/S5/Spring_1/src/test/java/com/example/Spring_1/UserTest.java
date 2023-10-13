package com.example.Spring_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.example.Spring_1.model.User;

class UserTest {
	
	User u;
	
	@BeforeAll
	static void beforeAllTest() {
		System.out.println("beforeAllTest");
	}
	
	@BeforeEach
	void beforeTest() {
		u = new User("Mario", "Rossi", "Roma", "m.rossi@example.com", "qwerty");
		System.out.println("beforeTest");
	}

	@Test
	void testEmail() {
		//User u = new User("Mario", "Rossi", "Roma", "m.rossi@example.com", "qwerty");
		assertEquals("m.rossi@example.com", u.getEmail());
		System.out.println("testEmail");
	}
	
	@Test
	@Disabled
	void testPassword() {
		//User u = new User("Mario", "Rossi", "Roma", "m.rossi@example.com", "qwerty");
		assertTrue(u.getPassword().length() > 5);
		System.out.println("testPassword");
	}
	
	@AfterEach
	void afterTest() {
		u = null;
		System.out.println("afterTest");
	}
	
	@AfterAll
	static void afterAllTest() {
		System.out.println("afterAllTest");
	}

}
