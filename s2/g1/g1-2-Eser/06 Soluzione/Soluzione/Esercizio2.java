package it.epicode.exercises.week3.giorno1;

import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int kilometri, litri, distanza;

		try {
			System.out.print("Inserire i kilometri percorsi: ");
			kilometri = scanner.nextInt();
			System.out.print("Inserire i litri di benzina consumati: ");
			litri = scanner.nextInt();

			distanza = kilometri / litri;

			System.out.println("La tua auto percorre " + distanza + " kilometri al litro");

		} catch (ArithmeticException ex) {
			// Intercetta l'eccezione di divisione per zero
			System.out.println("Impossibile che la tua macchina non consumi carburante: " + ex.getMessage());
			// Stampa in console lo stacktrace dell'eccezione
			ex.printStackTrace();
		} catch (Exception ex) {
			// Intercetta qualsiasi altra eccezione
			System.out.println("Questo è un altro tipo di errore: " + ex.getMessage());
			ex.printStackTrace();

		}

		System.out.println("Fine del programma.");
	}
}