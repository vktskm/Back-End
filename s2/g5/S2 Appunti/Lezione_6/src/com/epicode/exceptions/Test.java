package com.epicode.exceptions;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	
	Logger log = LoggerFactory.getLogger(MainProject.class);
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Digita 1 per somma o 2 per divisione, 0 per uscire: ");
			// try -> blocco di codice sotto controllo che potrebbe scatenarmi delle eccezioni
			try {
				// Potrebbe verificarsi un eccezione di tipo NumberFormatException
				// Quando viene inserito un valore che non è possibile trasformare in un numero
				int scelta = Integer.parseInt(sc.nextLine());
				if(scelta == 1) {
					int res = somma();
					System.out.println(res);
				} else if (scelta == 2) {
					int res = divisione(); // non gestisco ecc? questa si propaga verso il metodo chiamante
					System.out.println(res);
				} else if (scelta == 0) {
					System.out.println("FINE");
					break;
				} else if (scelta < 0) {
					// Nel caso in cui viene inserito un valore negativo 
					// genero manualmente un eccezione di tipo MyException che verrà catturata dal blocco catch
					throw new MyException("Valore negativo non consentito!!!");
				} else {
					System.out.println("Valore errato");
				}
				// catch -> blocco di codice che contiene la logica per gestire eventuali eccezioni scatenate nel blocco try
				// posso avere catch multipli e di solito è bene scriverli dal più specifico al più generico
			} catch (NumberFormatException e) {
				log.error("Formato del numero non corretto!!!");
				//System.out.println("Formato del numero non corretto!!!");
			} catch (MyException e) {
				log.error(e.getMessage());
				//System.out.println(e.getMessage());
			} catch (Exception e ) {
				log.error("Errore Generico!!!");
				//System.out.println("Errore Generico!!!");
			} finally {
				// Blocco Finally viene eseguito sempre, sia se tutto va a buon fine, 
				// che se viene scatenata una eccezione poi catturata dal blocco catch
				System.out.println("Sono il blocco Finally");
			}
		}
	}
	
	private int somma() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un numero: ");
		// Potrebbe verificarsi un eccezione di tipo NumberFormatException
		// Quando viene inserito un valore che non è possibile trasformare in un numero
		// Se non viene gestita in questo punto l'eccezione si propaga fino a raggiungere il main
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("Inserisci un numero: ");
		// Potrebbe verificarsi un eccezione di tipo NumberFormatException
		// Quando viene inserito un valore che non è possibile trasformare in un numero
		// Se non viene gestita in questo punto l'eccezione si propaga fino a raggiungere il main
		int num2 = Integer.parseInt(sc.nextLine());
		return num1 + num2;
	}
	
	private int divisione() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un numero: ");
		// Potrebbe verificarsi un eccezione di tipo NumberFormatException
		// Quando viene inserito un valore che non è possibile trasformare in un numero
		// Se non viene gestita in questo punto l'eccezione si propaga fino a raggiungere il main
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("Inserisci un numero: ");
		// Potrebbe verificarsi un eccezione di tipo NumberFormatException
		// Quando viene inserito un valore che non è possibile trasformare in un numero
		// Se non viene gestita in questo punto l'eccezione si propaga fino a raggiungere il main
		int num2 = Integer.parseInt(sc.nextLine());
		try {
			// Potrebbe verificarsi un eccezione di tipo ArithmeticException
			// Quando si prova a dividere per 0
			return num1 / num2; // ecc viene scatenata in questo punto... non la gestisco? si propaga verso il metodo chiamante
		} catch (ArithmeticException e) {
			log.error("Divisione per 0 non fattibile!!!!");
			//System.out.println("Divisione per 0 non fattibile!!!!");
		}
		return 0;
	}

}
