package com.epicode.esercizi;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {


		//Esercizio #3 - while
		//Scrivere un programma che chiede di inserire una stringa 
		//e la suddivida in caratteri separati dalla virgola. 
		//Il programma si ripete fino a che l'utente non inserisce 
		//la stringa ":q"
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("Inserici una stringa: ");
			String testo = sc.nextLine();
			if(testo.equals(":q")) {
				break;
			}
			String[] testoSplittato = testo.split(""); // Split taglia una stringa in base ad una regex
			for (int i = 0; i < testoSplittato.length; i++) {
				System.out.print(testoSplittato[i] + ",");
			}
			System.out.println();
		}
		System.out.println("FINE");
		


	}

}
