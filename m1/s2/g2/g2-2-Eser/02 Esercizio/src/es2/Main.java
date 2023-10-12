package es2;

/* Esercizio #2
 * Scrivere una funzione che accetti un intero N e restituisca una lista ordinata 
 * di N interi casuali da 0 a 100. 
 * Scrivere una seconda funzione che accetti una lista e restituisca una nuova 
 * lista composta dagli elementi della prima lista seguiti dagli stessi elementi 
 * disposti in ordine inverso. 
 * Scrivere una terza funzione che accetti una lista ed un booleano: 
 * se il booleano è true stampa i valori in posizioni pari, altrimenti stampa i 
 * valori in posizioni dispari. 
 * Creare una main che utilizzi le due funzioni. 
 * Utilizzare l'interfaccia List e l'implementazione ArrayList.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
    	functionOne();
		functionTwo();
		functionThree();
	}

	public static void functionOne() {

		List<Integer> listOne = new ArrayList<>();
		int n = 10;

		for (int i = 0; i < n; i++) {
			listOne.add((int) (Math.random() * 100) + 1);
		}

		System.out.println(listOne);

		listOne.sort(null);
		System.out.println(listOne);

	}

	public static void functionTwo() {

		List<String> listTwo = new ArrayList<>();

		listTwo.add("In");
		listTwo.add("Switzerland");
		listTwo.add("you");
		listTwo.add("work");
		listTwo.add("serenity");

		System.out.println(listTwo);

		Collections.reverse(listTwo);

		System.out.println(listTwo);
	}

	public static void functionThree() {

		List<Integer> listThree = new ArrayList<>();

		boolean isEven = false;

		listThree.add(0);
		listThree.add(1);
		listThree.add(2);
		listThree.add(3);
		listThree.add(4);

		//Stampa i valori dispari con isEven = false
		System.out.println("Prints odd values");
		for (int i = 0; i < listThree.size(); i++) {
			if (isEven && i % 2 == 0) {
				System.out.println(listThree.get(i));
			} else if (!isEven && i % 2 != 0) {
				System.out.println(listThree.get(i));
			}
		}
		
		isEven = true;
		//Stampa i valori pari con isEven = true
				System.out.println("Prints even values");
				for (int i = 0; i < listThree.size(); i++) {
					if (isEven && i % 2 == 0) {
						System.out.println(listThree.get(i));
					} else if (!isEven && i % 2 != 0) {
						System.out.println(listThree.get(i));
					}
				}
	   }//funcThree
}
