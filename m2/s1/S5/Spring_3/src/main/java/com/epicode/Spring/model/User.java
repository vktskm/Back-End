package com.epicode.Spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
	
	private Long id;
	private String name;
	private String lastname;
	private String city;
	private Integer age;
	private String email;
	private String password;
	
	public User(String name, String lastname, String city, Integer age, String email, String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.city = city;
		this.age = age;
		this.email = email;
		this.password = password;
	}

}
