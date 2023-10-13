package com.epicode.introSpring.DipendencyInjection;

public class TestDependencyInjection {

	public static void main(String[] args) {

		Phone p = new Phone("Tim", "123456789");
		AmericanAddress aa = new AmericanAddress("New York", "5th avenue", "New York");
		EuropeanAddress ea = new EuropeanAddress("Roma", "via Epicode", "Roma");
		EuropeanAddress ea2 = new EuropeanAddress("Milano", "via abc", "Milano");
		
		// Dependency injection tramite costruttore
		Person pers1 = new Person("Mario Rossi", aa, p);
		Person pers2 = new Person("Giuseppe Verdi", ea, p);
		
		// Dependency injection tramite metodo set;
		Person pers3 = new Person("Francesca Neri");
		pers3.setAddress(ea2);
		pers3.setPhone(new Phone("Vodafone", "987654321"));

	}

}
