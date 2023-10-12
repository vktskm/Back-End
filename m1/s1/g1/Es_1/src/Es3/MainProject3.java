package Es3;

/* Esercizio3
 * Implementare un metodo main che chiede all'utente di inserire tre stringhe da tastiera e scrive 
 * in console la concatenazione delle stringhe in ordine di inserimento inverso.
 * */

import java.util.Scanner;

public class MainProject3 {
	
	static public Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("---------- SOLUZIONE 1 ----------");
		SoluzioneScanner1();
		
		System.out.println("---------- SOLUZIONE 2 ----------");
		SoluzioneScanner2();
		
		sc.close();
	}
	
	public static void SoluzioneScanner1(){

		
		System.out.print("Inserisci nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Inserisci cognome: ");
		String cognome = sc.nextLine();
		
		System.out.print("Inserisci citta': ");
		String citta = sc.nextLine();
	    
		System.out.println("Stampa in ordine di inserimento: "+nome+" "+cognome+" "+citta);
		System.out.println("Stampa in ordine di inserimento inverso: "+citta+" "+cognome+" "+nome);
	}
	
	public static void SoluzioneScanner2(){
		
		String[] parole = new String[3];
		
		System.out.print("Inserisci nome: ");
		parole[0] = sc.nextLine();
		
		System.out.print("Inserisci cognome: ");
		parole[1] = sc.nextLine();
		
		System.out.print("Inserisci citta': ");
		parole[2] = sc.nextLine();
		
		System.out.println("Stampa in ordine di inserimento: ");
		for (int i = 0; i < parole.length; i++) {
			System.out.print(parole[i]+ " ");
		}
		
		System.out.println("\nStampa in ordine di inserimento inverso: ");
		for (int i = parole.length-1; i >= 0 ; i--) {
			System.out.print(parole[i] + " ");
		}
	}
		

}
