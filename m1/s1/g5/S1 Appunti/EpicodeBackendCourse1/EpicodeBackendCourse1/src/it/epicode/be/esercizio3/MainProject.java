package it.epicode.be.esercizio3;

import java.util.Scanner;

public class MainProject {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		SoluzioneScanner1();
		
		System.out.println("*************");
		
		SoluzioneScanner2();
		
	}
	
	public static void SoluzioneScanner1(){
		System.out.print("Inserisci nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Inserisci cognome: ");
		String cognome = sc.nextLine();
		
		System.out.print("Inserisci città: ");
		String citta = sc.nextLine();
		
		System.out.println(nome+cognome+citta);
		System.out.println(citta+cognome+nome);
	}
	
	public static void SoluzioneScanner2(){
		String[] parole = new String[3];
		
		System.out.print("Inserisci nome: ");
		parole[0] = sc.nextLine();
		
		System.out.print("Inserisci cognome: ");
		parole[1] = sc.nextLine();
		
		System.out.print("Inserisci città: ");
		parole[2] = sc.nextLine();
		
		for (int i = 0; i < parole.length; i++) {
			System.out.print(parole[i]);
		}
		
		for (int i = parole.length-1; i >= 0 ; i--) {
			System.out.print(parole[i]);
		}
	}
		

}
