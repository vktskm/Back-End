package app;

import java.util.Scanner;
//Questa è l'istruzione di importazione, che consente al programma Java di utilizzare la classe Scanner.

public class MainProject {
	
	static int pippo = 15;
	/* Quando dichiari una variabile statica all'esterno della funzione main, la variabile diventa 
	 * un membro della classe stessa e non appartiene a una specifica istanza dell'oggetto. 
	 * Pertanto, puoi accedere alla variabile pippo da qualsiasi parte della classe senza dover 
	 * creare un'istanza dell'oggetto.
	 * */

	public static void main(String[] args) {
		// istruzioni del mio programma
		
		/*
		 * Commenti multilinea
		 * 
		 */
		
		boolean b = true; // true/false;
		char c = 'c'; // apici singoli, un carattere
		int i = 25; // valore numerico non decimale, senza virgola
		double d = 25.5; // valore numerico decimale
		String s = "ciao"; // apici doppi, una stringa
		
		int val1 = 10; // Dichiarare ed inizializzare una variabile
		int val2; // Dichiarato una variabile
		val2 = 10; // Inizializzato una varibile
		final int VAL3 = 15; // Definisco ed inizializzo una costante
	
		int[] arrNum =  new int[5]; 
              // creo un array di valori numerici di dimensione fissa (5) con indice da 0 a n-1 
		arrNum[0] = 25; // inizializzo un valore nell'indice 0 del mio array
		arrNum[1] = 10; // inizializzo un valore nell'indice 1 del mio array
		System.out.println("Stampa il valore arrNum[1]: " + arrNum[1]); // Stampo il valore in console
		String[] arrString = new String[3]; 
              // creo un array di valori di tipo String di dimensione fissa (3) con indice da 0 a n-1 
		
		char[] arrChar = {'a', 'b', 'c'}; // creo un array e lo popolo immediatamente con dei valori
		//Stampa i valori di arrChar
		for (int j=0; j<arrChar.length; j++) {
			System.out.println("Stampa il valore arrChar["+ j +"]: " + arrChar[j]);
		}
		
		//System.out.println(j); ERRORE variabile J definita nello scope del ciclo for 
		
		int num1 = 25;//num1 è 25
		int num2 = num1;//num2 è 25
		long num3 = 193;
		int num4 = (int) num3;
		double num5 = num4; // 193.0
		int num6 = (int) num5; // 193
		
		
		//let c = 10/3; // 3.3333333
		int cj = 10/3; // 3
		int resto = 10%3; //1
		
		num1 = num1 + 5;
		num1 += 5;
		
		num1 = num1 - 5;
		num1 -= 5;
		
		num1 = num1 * 5;
		num1 *= 5;
		
		num1 = num1 / 5;
		num1 /= 5;
		
		num1 = num1 % 5;
		num1 %= 5;
		
		boolean cond1 = 5 > 0 && 5 < 10; //true && true ->  true
		boolean cond2 = 5 > 10 || 5 < 10; //false && true ->  true
		boolean cond3 = !(5 > 10); //!false ->  true
		boolean cond4 = 5 > 10 ^ 5 < 10; //false && true ->  true -> 
		//Per essere vero la cond4 solo una delle condizione deve essere vera, 
		//altrimenti in ogni altro caso è false.
		
	
		int res = somma(25, 10);
		System.out.println("La somma e' uguale a " + res);
		stampaSomma(25, 10);
		
		System.out.println("Valore di pippo e' : " + pippo);
		
		// Inserire un valore da tastiera
		Scanner sc = new Scanner(System.in);
		/* Questa istruzione crea un nuovo oggetto Scanner chiamato sc. Stiamo 
		 * utilizzando il costruttore Scanner(System.in) per istanziare l'ogget-
		 * to Scanner e associarlo al flusso di input standard (System.in), che 
		 * rappresenta l'input da tastiera. */
		
		System.out.print("Inserisci il tuo nome: ");
		String nome = sc.nextLine();
		/* Questa parte dell'istruzione si divide in due parti principali:
		 * a. sc: Qui sc è il nome dell'oggetto di tipo Scanner, che è stato creato 
		 * in precedenza usando l'istruzione Scanner sc = new Scanner(System.in);. 
		 * Questo oggetto Scanner è stato associato al flusso di input standard 
		 * (System.in), che rappresenta l'input da tastiera.
		 * b. nextLine(): nextLine() è un metodo fornito dalla classe Scanner. Quando 
		 * chiamiamo sc.nextLine(), stiamo essenzialmente dicendo all'oggetto Scanner 
		 * di leggere l'intera riga di testo (fino a quando l'utente preme il tasto 
		 * Invio) dalla tastiera. 
		 * Il testo letto sarà quindi restituito come una stringa.*/
		System.out.print("Inserisci il tuo cognome: ");

		String cognome = sc.nextLine();
		System.out.println("Ciao " + nome + " " + cognome);
		//Chiusura del flusso di Input
		sc.close();
		
		// Istruzioni GIT
		// git clone https://linkreposotorygit
		
		// git init
		// git add .
		// git commit -m 'messaggio'
		// git branch -M main
		// git remote add origin https://linkreposotorygit
		// git push -u origin main
		
		// git add .
		// git commit -m 'messaggio'
		// git push
		
		// git pull
			
	}
	
	public static int somma(int x, int y){
		System.out.println("Stampa il valore final di pippo : "+pippo);
		int result = x + y;
		return result;
	}
	
	public static void stampaSomma(int x, int y) {
		System.out.println("Stampa il valore final di pippo : "+pippo);
		int result = x + y;
		System.out.println("Stampa la somma : " + result);
	}

}
