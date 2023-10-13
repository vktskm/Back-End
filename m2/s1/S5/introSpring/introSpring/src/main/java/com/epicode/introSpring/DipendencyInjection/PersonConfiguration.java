package com.epicode.introSpring.DipendencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersonConfiguration {
	
	@Bean
	@Scope("singleton")
	public IAddress address() {
		return new EuropeanAddress("Roma", "Via Epicode", "Roma");
	}
	
	@Bean
	@Scope("prototype")
	public IAddress address(String city, String street, String state) {
		return new EuropeanAddress(city, street, state);
	}
	
	@Bean
	@Scope("singleton")
	public Phone phone() {
		return new Phone("Tim", "123456789");
	}
	
	@Bean
	@Scope("singleton")
	public Person person() {
		return new Person("Mario Rossi", address(), phone());
	}
	
	@Bean
	@Scope("prototype")
	public Person personPR(String fullName, String city, String street, String state) {
		return new Person(fullName, address(city, street, state), phone());
	}

}
