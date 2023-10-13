package com.epicode.Spring.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.model.User;
import com.github.javafaker.Faker;

@Configuration
public class UserConfiguration {
	
	// leggo il valore della proprietà definita nel file application.properties
		@Value("${user.admin.name}") private String adminName;
		@Value("${user.admin.lastname}") private String adminLastname;
		@Value("${user.admin.city}") private String adminCity;
		@Value("${user.admin.age}") private Integer adminAge;
		@Value("${user.admin.email}") private String adminEmail;
		@Value("${user.admin.password}") private String adminPassword;
		
		@Bean("customUserBean")
		@Scope("prototype")
		public User customUser() {
			return new User();
		}
		
		@Bean("adminUserBean")
		@Scope("singleton")
		public User adminUser() {
			return new User(adminName, adminLastname, adminCity, adminAge, adminEmail, adminPassword);
		}
		
		@Bean("fakeUserBean")
		@Scope("prototype")
		public User fakeUser() {
			Faker faker = new Faker(new Locale("it-IT"));
			User u = new User();
			u.setName(faker.name().firstName());
			u.setLastname(faker.name().lastName());
			u.setCity(faker.address().cityName());
			u.setAge(faker.number().numberBetween(18, 80));
			u.setEmail(faker.internet().emailAddress());
			u.setPassword(faker.internet().password());
			return u;
		}

}
