package main.esercizio2;

import java.util.Arrays;

public class Sim {
	
	long number;
	double credit;
	double duration;
	
	public Sim(long number) {
		this.number = number;
		this.credit = 00.00;
	}
	
	Calls call = new  Calls(345678, 987654, 1.32);
	Calls call2 = new Calls(345678, 198765, 5.37);
	Calls call3 = new Calls(345678, 234567, 4.01);
	Calls call4 = new Calls(345678, 456789, 0.48);
	Calls call5 = new Calls(345678, 675432, 2.26);
	
	Object[] previousCalls = {call, call2, call3, call4, call5};
	
	public void printPhoneData(Sim sim) {
		System.out.println("Phone number: " + sim.number);
		System.out.println("Phone credit: " + sim.credit);
		System.out.println("Last 5 calls: " + Arrays.toString(previousCalls));
		//Di solito call dovrebbe stampare l'indirizzo della memoria , ma grazie alla
		//funzione toString di Calls mi stampa tutto l'oggetto
		System.out.println("1 " + call);
		System.out.println("2 " + call2);
		System.out.println("3 " + call3);
		System.out.println("4 " + call4);
		System.out.println("5 " + call5);
		
	}

}
