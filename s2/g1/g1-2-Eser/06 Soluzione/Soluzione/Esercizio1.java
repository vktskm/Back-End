package it.epicode.exercises.week3.giorno1;

import java.util.Random;
import java.util.Scanner;

public class Esercizio1 {
	public static void main(String[] args) {

		int[] array = creaArrayCasuale();

		stampaArray(array);

		leggiNumeroPosizione(array);

	}

	private static void leggiNumeroPosizione(int[] array) {
		Scanner in = new Scanner(System.in);
		int i, numero, posizione;
		boolean continua = true;
		do {
			System.out.println("Inserire un numero seguito dal tasto Invio. Inserire 0 per uscire");
			numero = in.nextInt();
			if (numero != 0) {
				System.out.println("Inserire la posizione in cui inserire il numero seguita dal tasto Invio");
				posizione = in.nextInt();
				try {
					array[posizione] = numero;
					stampaArray(array);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Posizione fuori dal limite dell'array: " + posizione);
				}
			} else {
				continua = false;
			}
		} while (continua);

	}

	private static void stampaArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Valore posizione " + i + ": " + array[i]);
		}

	}

	private static int[] creaArrayCasuale() {
		int[] array = new int[5];
		// Istanzia un oggetto random che pemrette di ottenere numeri casuali
		Random randomGenerator = new Random();
		for (int i = 0; i < array.length; i++) {
			// Inserisce in posizione i-esima un valore casuale compreso tra 0 e 10
			array[i] = randomGenerator.nextInt(11);
		}
		return array;
	}

}