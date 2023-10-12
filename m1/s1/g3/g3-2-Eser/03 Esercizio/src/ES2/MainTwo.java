package ES2;
/*Esercizio #2 - switch
 * Scrivere un programma che chiede un intero in ingresso e lo stampa in lettere se il valore 
 * è compreso tra 0 e 3, altrimenti stampa un messaggio d'errore usando il costrutto switch.
 * */

import java.util.Scanner;

public class MainTwo {
	
public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("Insert a number:");
		int number = input.nextInt();
		
		CheckNumber(number);
		
		input.close();
	}
	
	public static void CheckNumber(int number) {
		switch(number) {
		case 0:
			System.out.println("Z E R O");
			break;
		case 1:
			System.out.println("O N E");
			break;
		case 2:
			System.out.println("T W O");
			break;
		case 3:
			System.out.println("T H R E E");
			break;
		default:
			System.out.println("ERROR: could not read number. Try again.");
		}
		
		
	}

}
