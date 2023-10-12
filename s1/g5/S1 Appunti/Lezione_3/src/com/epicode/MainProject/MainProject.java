package com.epicode.MainProject;

import java.util.Scanner;

import com.epicode.OOP.Veicolo;

public class MainProject {

	public static void main(String[] args) {
		
		int age = 45;
		
		// IF - ELSE IF - ELSE
		
		// if -> espressione booleana restituisce true
		if(age > 18) {
			// Blocco di istruzioni
		} else if(age == 18) { // else if -> espressione booleana del blocco if è false e quella del blocco else if restituisce true
			
		} else { // else -> espressione booleana restituisce false
			// Blocco di istruzioni
		}
		
		// SWITCH
		// L’istruzione switch è utile in tutti quei casi in cui sia necessario decidere tra opzioni multiple 
		
		int giorno = 4;
		
//		if(giorno == 1) {
//			System.out.println("Lunedì");
//		} else if(giorno == 2) {
//			System.out.println("Martedi");
//		} else if(giorno == 3) {
//			System.out.println("Mercoledi");
//		}
		
		switch (giorno) {
		case 1:
			System.out.println("Lunedì");
			break;
		case 2:
			System.out.println("Martedi");
			break;
		case 3:
			System.out.println("Mercoledi");
			break;
		case 4:
			System.out.println("Giovedi");
			break;
		case 5:
			System.out.println("Venerdi");
			break;
		case 6:
			System.out.println("Sabato");
			break;
		case 7:
			System.out.println("Domenica");
			break;
		default:
			System.out.println("Valore non valido");
			break;
		}
		
		// WHILE
		// Il ciclo while permette di eseguire ripetutamente un blocco di istruzioni più volte finché un’espressione booleana rimane vera. 
		
		int num = 10;
		
		// Condizione booleana da verificare ad ogni iterazione
		while(num > 0) {
			// Blocco di istruzioni 
			num--;
		}
		
		num = 10;
		
		while(true) {
			// Blocco di istruzioni 
			if(num == 5) {
				break;
			}
			num--;
		}
		
		// DO-WHILE
//		do {
//			// Blocco di istruzioni
//		} while(true); // Condizione booleana da verificare ad ogni iterazione
		
		String username = "admin";
		String myUsername;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Inserisci il tuo username: ");
			myUsername = sc.nextLine();
		} while(!myUsername.equals(username));
		System.out.println("Sei Loggato!!!");
		
		
		// FOR 
		for(int i=0; i<=10; i++) {
			// Blocco di istruzioni
			if(i%2 == 0) {
				continue;
			} else if(i == 5) {
				break;
			}
			System.out.println(i);
		}

		// Operatore Ternario
		// condizione ? true : false;
		 String x = username.equals("admin") ? "Ciao Admin" : "";
		 System.out.println(x);
		
		//....
		 
		 Veicolo v = new Veicolo();
		 v.setMarca("Fiat");
		 v.modello = "500";
	}

}
