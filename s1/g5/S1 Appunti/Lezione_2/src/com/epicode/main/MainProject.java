package com.epicode.main;

import java.util.Scanner;

import com.epicode.casses.Veicolo;

public class MainProject {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Creo una istanza di tipo Veicolo
		// Soluzione 1
//		Veicolo v1 = new Veicolo();
//		v1.marca = "Fiat";
//		v1.modello = "500";
//		v1.targa = "AB123CD";
//		
//		Veicolo v2 = new Veicolo();
//		v2.marca = "Ford";
//		v2.modello = "Fiesta";
//		v2.targa = "CD456AB";
//		
//		Veicolo v3 = new Veicolo();
//		v3.marca = "BMW";
//		v3.modello = "X5";
//		v3.targa = "EF789LM";
		
		// Soluzione 2
//		Veicolo v1 = MainProject.creaVeicolo("Fiat", "500", "AB123CD");
//		Veicolo v2 = creaVeicolo("Ford", "Fiesta", "CD456AB");
//		Veicolo v3 = creaVeicolo("BMW", "X5", "EF789LM");
		
		// Soluzione 3
		// creo una istanza utilizzando il costruttore con parametri
		Veicolo v1 = new Veicolo("Fiat", "500", "AB123CD");
		Veicolo v2 = new Veicolo("Ford", "Fiesta", "CD456AB");
		Veicolo v3 = new Veicolo("BMW", "X5", "EF789LM");
		Veicolo v4 = new Veicolo("BMW", "X5", "EF789LM");
				
		// Assegno il riferimento alla zona di memoria di v4 a v5
		Veicolo v5 = v4;
		// se modifico un parametro da v5 si modifica anche in v4 perchè puntano alla stessa zona di memoria
		v5.targa = "123456";
		
		Veicolo v6 = v1.ritornaVeicolo();
		
		// Cosa che non succede con i tipi di dato primitivi
		// i tipi primitivi passano una copia del loro valore
		int abc = 25;
		int n = abc; // sto passando ad n una copia del valore di abc
		n = 0; // se modifico n, abc rimane con il suo valore originale
		abc = 5;
		System.out.println(abc);
		String x = "Ciao";
		// String è considerato un tipo primitivo passano una copia del loro valore
		String y = x;
		x = "abc";
		System.out.println(x); // abc
		System.out.println(y); // Ciao
		
		// passo al metodo il riferimento alla zona di memoria contenuto in v5
		cambiaTarga(v5);
		// Passo una copia del valore
		cambiaValoreTarga(v5.targa);
		// Passo una copia del valore
		cambiaNumero(abc);
		System.out.println(abc);
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5.targa);
		System.out.println(v6);
		
		String xt = "Test";
		String yt = "Test";
		
		int xn = 25;
		int yn = 25;
		
		System.out.println(xn == yn); // true -> == verifica il valore di due variabili primitive
		System.out.println(xt.equals(yt)); // true -> verifica il valore dei due stringhe
		System.out.println(v5 == v4); // == verifica il riferimento alla zona di memoria
		System.out.println(v3.equals(v4)); // true -> verifica il valore dei due ogg
		
		
//		System.out.println(v1.marca + " targa: " + v1.targa + " veicoli prodotti: " + Veicolo.num);
//		System.out.println(v2.marca + " targa: " + v2.targa + " veicoli prodotti: " + Veicolo.num);
//		System.out.println(v3.marca + " targa: " + v3.targa + " veicoli prodotti: " + Veicolo.num);
//	
//		v1.avviaVeicolo();
//		v2.avviaVeicolo();
//		v3.avviaVeicolo();
//
//		Veicolo.aggiornaVeicolo();
	}
	
	// Metodo per evitare la duplicazione del codice
	public static Veicolo creaVeicolo(String marca, String modello, String targa) {
		// creo una istanza utilizzando il costruttore senza parametri
		Veicolo v = new Veicolo();
		v.marca = marca;
		v.modello = modello;
		v.targa = targa;
		return v;
	}

	public static void cambiaTarga(Veicolo v) {
		// se modifico il valore nella zona di memoria questa modifica sarà globale
		v.targa = "TEST";
	}
	
	public static void cambiaValoreTarga(String targa) {
		targa = "TEST5";
	}
	
	public static void cambiaNumero(int n) {
		n = 15;
	}
	
}
