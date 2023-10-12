package com.epicode.collections;

public class User {
	
	private String name;
	private String lastname;
	private String city;
	
	public User(String name, String lastname, String city) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lastname=" + lastname + ", city=" + city + "]";
	}
	
	

}
