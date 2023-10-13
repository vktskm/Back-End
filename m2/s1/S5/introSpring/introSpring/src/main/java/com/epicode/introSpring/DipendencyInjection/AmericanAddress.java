package com.epicode.introSpring.DipendencyInjection;

public class AmericanAddress implements IAddress {
	
	private String city;
	private String street;
	private String state;
	
	public AmericanAddress(String city, String street, String state) {
		super();
		this.city = city;
		this.street = street;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AmericanAddress [city=" + city + ", street=" + street + ", state=" + state + "]";
	}
	
	

}
