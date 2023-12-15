package com.epicode.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring92Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring92Application.class, args);
		
		System.out.println("Service running... port 8082");
	}

}
