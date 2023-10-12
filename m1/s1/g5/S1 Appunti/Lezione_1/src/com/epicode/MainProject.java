package com.epicode;

import java.util.Scanner;

public class MainProject {
	
	static int pippo = 15;

	public static void main(String[] args) {
		// istruzioni del mio programma
		
		/*
		 * 
		 * Commenti multilinea
		 * 
		 */
		
		/**
		 *	@author Umberto Emanuele
		 * Commenti per JAVADOC
		 * 
		 */
		
		boolean b = true; // true/false;
		char c = 'c'; // apici singoli, un carattere
		int i = 25; // valore numerico non decimale, senza virgola
		double d = 25.5; // valore numerico decimale
		String s = "ciao"; // apici doppi, una stringa
		
		int val1 = 10; // Dichiarare ed inizializzare una variabile
		int val2; // Dichiarato una variabile
		val2 = 10; // Inizializzato una varibile
		final int VAL3 = 15; // Definisco ed inizializzo una costante
	
		int[] arrNum =  new int[5]; // creo un array di valori numerici di dimensione fissa (5) con indice da 0 a n-1 
		arrNum[0] = 25; // inizializzo un valore nell'indice 0 del mio array
		arrNum[1] = 10; // inizializzo un valore nell'indice 1 del mio array
		System.out.println(arrNum[1]); // Stampo il valore in console
		String[] arrString = new String[3]; // creo un array di valori di tipo String di dimensione fissa (3) con indice da 0 a n-1 
		
		char[] arrChar = {'a', 'b', 'c'}; // creo un array e lo popolo immediatamente con dei valori
		
		for (int j=0; j<arrChar.length; j++) {
			System.out.println(arrChar[j]);
		}
		
		//System.out.println(j); ERRORE variabile J definita nello scope del ciclo for 
		
		int num1 = 25;
		int num2 = num1;
		long num3 = 193;
		int num4 = (int) num3;
		double num5 = num4; // 193.0
		int num6 = (int) num5; // 193
		
		
		//let c = 10/3; // 3.3333333
		int cj = 10/3; // 3
		int resto = 10%3; //1
		
		num1 = num1 + 5;
		num1 += 5;
		
		num1 = num1 - 5;
		num1 -= 5;
		
		num1 = num1 * 5;
		num1 *= 5;
		
		num1 = num1 / 5;
		num1 /= 5;
		
		num1 = num1 % 5;
		num1 %= 5;
		
		boolean cond1 = 5 > 0 && 5 < 10; //true && true ->  true
		boolean cond2 = 5 > 10 || 5 < 10; //true && false ->  true
		boolean cond3 = !(5 > 10); //!false ->  true
		boolean cond4 = 5 > 10 ^ 5 < 10; //true && false ->  true -> per essere vero solo una delle condizione deve essere vera, altrimenti in ogni altro caso è false
		
	
		int res = somma(25, 10);
		System.out.println(res);
		stampaSomma(25, 10);
		
		System.out.println(pippo);
		
		// Inserire un valore da tastiera
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserisci il tuo nome: ");
		String nome = sc.nextLine();
		System.out.print("Inserisci il tuo cognome: ");
		String cognome = sc.nextLine();
		System.out.println("Ciao " + nome + " " + cognome);
		
		// Istruzioni GIT
		// git clone https://linkrepogit
		
		// git init
		// git add .
		// git commit -m 'messaggio'
		// git branch -M main
		// git remote add origin https://linkrepogit
		// git push -u origin main
		
		// git add .
		// git commit -m 'messaggio'
		// git push
		
		// git pull
		
		
	}
	
	public static int somma(int x, int y){
		System.out.println(pippo);
		int result = x + y;
		return result;
	}
	
	public static void stampaSomma(int x, int y) {
		System.out.println(pippo);
		int result = x + y;
		System.out.println(result);
	}

}
