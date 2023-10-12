package it.epicode.exercises.week1.giorno4;

import java.util.Scanner;

public class Esercizio1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("**********        Due rettangoli                          **********");
		System.out.println("*                                                                  *");
		System.out.println("*  Inserire la lunghezza del rettangolo 1 seguita dal tasto Invio  *");
		System.out.println("*                                                                  *");
		double lunghezza1 = scanner.nextDouble();
		System.out.println("*                                                                  *");
		System.out.println("*  Inserire la larghezza del rettangolo 1 seguita dal tasto Invio  *");
		System.out.println("*                                                                  *");
		double larghezza1 = scanner.nextDouble();
		System.out.println("*                                                                  *");
		System.out.println("*  Inserire la lunghezza del rettangolo 2 seguita dal tasto Invio  *");
		System.out.println("*                                                                  *");
		double lunghezza2 = scanner.nextDouble();
		System.out.println("*                                                                  *");
		System.out.println("*  Inserire la larghezza del rettangolo 2 seguita dal tasto Invio  *");
		System.out.println("*                                                                  *");
		double larghezza2 = scanner.nextDouble();
		
		Rettangolo rettangolo1 = new Rettangolo(lunghezza1, larghezza1);
		System.out.println("Rettangolo 1");
		stampaRettangolo(rettangolo1);
		
		Rettangolo rettangolo2 = new Rettangolo(lunghezza1, larghezza1);
		System.out.println("Rettangolo 2");

		stampaRettangolo(rettangolo1);
		
		stampaDueRettangoli(rettangolo1, rettangolo2);

	}
	
	public static void stampaRettangolo (Rettangolo rettangolo) {
		
		System.out.println("Perimetro rettangolo: " + rettangolo.perimetro());

		System.out.println("Area rettangolo: " + rettangolo.area());
		
	}
	
	public static void stampaDueRettangoli (Rettangolo rettangolo1, Rettangolo rettangolo2) {
		
		System.out.println("Rettangolo 1: ");
		// Usa la funzione creata precedentemente per stampare i dati del rettangolo
		stampaRettangolo(rettangolo1);
		
		System.out.println("Rettangolo 2: ");
		// Usa la funzione creata precedentemente per stampare i dati del rettangolo
		stampaRettangolo(rettangolo2);
		
		double sommaArea = rettangolo1.area() + rettangolo2.area();
		double sommaPerimetro = rettangolo1.perimetro() + rettangolo2.perimetro();
		
		System.out.println("Somma perimetri: ");
		System.out.println(sommaPerimetro);
		
		System.out.println("Somma aree: ");
		System.out.println(sommaArea);
		
		
	}

}
