package com.epicode.Spring.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.model.Contact;
import com.github.javafaker.Faker;

@Configuration
public class ContactConfiguration {
	
	@Bean("contactBean")
	@Scope("prototype")
	public Contact customContact() {
		return new Contact();
	}
	
	@Bean("fakeContactBean")
	@Scope("prototype")
	public Contact fakeContact() {
		Faker faker = new Faker(new Locale("it-IT"));
		Contact c = new Contact();
		String name = faker.name().firstName();
		String lastname = faker.name().lastName();
		c.setName(name);
		c.setLastname(lastname);
		c.setCity(faker.address().cityName());
		c.setAge(faker.number().numberBetween(18, 80));
		c.setEmail(name.toLowerCase()+"."+lastname.toLowerCase()+"@example.com");
		c.setPassword(faker.internet().password());
		return c;
	}

}
