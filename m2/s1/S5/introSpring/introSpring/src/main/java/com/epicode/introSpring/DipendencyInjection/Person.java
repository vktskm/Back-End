package com.epicode.introSpring.DipendencyInjection;

public class Person {
	
	private String fullName;
	private IAddress address;
	private Phone phone;

	public Person(String fullName) {
		super();
		this.fullName = fullName;
		// Accoppiamento Forte tra Perona e indirizzo e telefono
		this.address = new EuropeanAddress("Roma", "Via Epicode 11", "Roma");
		this.phone = new Phone("Tim", "123456789");
	}

	// Dependency Injection sul costruttore
	// Accoppiamento debole basato su interfacce
	public Person(String fullName, IAddress address, Phone phone) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public IAddress getAddress() {
		return address;
	}

	// Dependency Injection sul metodo set
	public void setAddress(IAddress address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", EuropeanAddress=" + address + ", phone=" + phone + "]";
	}
	
	
	

}
