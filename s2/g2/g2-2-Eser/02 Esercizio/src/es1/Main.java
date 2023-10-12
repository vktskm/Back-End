package es1;

/* Esercizio #1
 * Scrivere un programma che chieda all'utente di inserire un intero N che 
 * rappresenti il numero di elementi da inserire e poi gli chieda di inserire 
 * N parole.
 * Il programma dovrà:
 * - stampare tutte le parole duplicate
 * - stampare il numero di parole distinte
 * - stampare l'elenco delle parole distinte
 * Utilizzare l'interfaccia Set e l'implementazione HashSet*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Set<String> words = new HashSet<String>();
		List<String> duplicateWords = new ArrayList<String>();

		Scanner input = new Scanner(System.in);

		System.out.println("Insert a number:");
		int wordNum = input.nextInt();

		for (int i = 0; i < wordNum; i++) {
			System.out.println("Insert word num." + (i + 1) + ":");
			String word = input.next();
			
			/*In questa riga 35 viene controllato se la parola è già presente nell'insieme words. 
			 * L'insieme words viene utilizzato per memorizzare le parole inserite dall'utente 
			 * senza duplicati.
			 * Se words.add(word) restituisce false, significa che la parola è già presente nel-
			 * l'insieme e quindi viene aggiunta all'insieme duplicateWords. 
			 * Questo insieme conterrà tutte le parole duplicate inserite dall'utente.*/
			
			if (!words.add(word)) {
				duplicateWords.add(word);
			}
		}
        
		//Stampa tutte le parole duplicate
		System.out.println("There are multiples of the word(s):");
		for (String word : duplicateWords) {
			System.out.println(word);
		}
        
		//Stampa il numero di parole distinte
		System.out.println("The number of different words you chose is:");
		System.out.println(words.size());
        
        
		//Stampa l'elenco delle parole distinte
		System.out.println("...and they are:");
		for (String word : words) {
			System.out.print(word + " / ");
		}

		input.close();
	}

}