package com.epicode.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring91Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring91Application.class, args);
		
		System.out.println("Service running... port 8081");
	}

}
