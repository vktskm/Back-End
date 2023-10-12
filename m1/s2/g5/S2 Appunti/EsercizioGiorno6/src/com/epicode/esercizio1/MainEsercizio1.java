package com.epicode.esercizio1;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainEsercizio1 {
	
	static Logger log = LoggerFactory.getLogger(MainEsercizio1.class);

	public static void main(String[] args) {
		int[] numArray = generaArray() ;
		stampaArray(numArray);
		cambiaValoreArray(numArray);
		log.info("FINE");
	}
	
	public static int[] generaArray() {
		// Creo un array vuoto di 5 elementi
		int[] arr = new int[5];
		
		// Creo un ogg random capace di generare valori casuali
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
			// Genero dei valori casuali da 0 a 10 (11 escluso)
			arr[i] = rand.nextInt(11);
		}
		// infine ritorna array con 5 elementi random
		return arr;	

	}

	public static void stampaArray(int[] arr) {
		// prende un array come paramentro e lo stampa in un ciclo FOR
		for (int i = 0; i < arr.length; i++) {
			log.info("Posizione: " + i + " Valore: " + arr[i]);
		}
	}

	public static void cambiaValoreArray(int[] arr) {
		Scanner sc = new Scanner(System.in);
		// Ciclo fino a quando un utente inserisce 0;
		while(true) {
			System.out.print("Inserisci un nuovo valore da 1 a 10 oppure 0 per uscire: ");
			try {
				int val = Integer.parseInt(sc.nextLine());
				if(val == 0) {
					// blocca l'esecuzione del ciclo e esce dal metodo
					return;
				} else if(val > 10) {
					// se il valore inserito dal utente è diverso da quello accettato sollevo un eccezione
					throw new MyNumberException("Devi inserire un valore da 1 a 10!!!!");
				}
				System.out.print("Inserisci una posizione da 0 a 4): ");
				int pos = Integer.parseInt(sc.nextLine());
				// controllo che l'indice dell'array sia accettato altrimenti viene sollevata un eccezione
				arr[pos] = val;

				// catch multipli per la gestione di tutte le eccezioni che potrebbero essere sollevate durante l'esecuzione del codice
			} catch (ArrayIndexOutOfBoundsException e) {
				log.error(e.getMessage());
			} catch (NumberFormatException e) {
				log.error(e.getMessage());
			} catch (MyNumberException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			stampaArray(arr);
		}
	}
}
