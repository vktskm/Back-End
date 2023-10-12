package ES4;

/*#Esercizio #4 - for
 * Scrivere un programma che chiede all'utente di inserire un numero intero e stampi 
 * il conto alla rovescia a partire da quel numero fino a zero.
 * */
import java.util.Scanner;

public class MainFour {
	
	public static void main(String[] args) {
		timer();
	}
	
	public static void timer() {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci un numero maggiore di 0 e fai countdown: ");
		
		int number = input.nextInt();
		
		for (int i = number-1; i>= 0; i--) {

		            System.out.println(i);
		}
		
		input.close();
	}

}
