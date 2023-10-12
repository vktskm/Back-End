package com.epicode.esercizio1;

public class MainProject1 {

	public static void main(String[] args) {

		Rettangolo r1 = new Rettangolo(25, 10);
		Rettangolo r2 = new Rettangolo(50, 25);
		
		System.out.println("***** Stampa perimetro e area di ogni rettangolo ******");
		stampaRettangolo(r1);
		stampaRettangolo(r2);
		
		System.out.println("***** Stampa perimetro, area, e la somma di ogni rettangolo ******");
		stampaDueRettangoli(r1, r2);

	}
	
	public static void stampaRettangolo(Rettangolo r) {
		System.out.println("Perimetro del Rettangolo: " + r.calcolaPerimetro());
		System.out.println("Area del Rettangolo: " + r.calcolaArea());
	}
	
	public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		int perimetroR1 = r1.calcolaPerimetro();
		int areaR1 = r1.calcolaArea();
		int perimetroR2 = r2.calcolaPerimetro();
		int areaR2 = r2.calcolaArea();
		
		System.out.println("Perimetro del Rettangolo: " + perimetroR1);
		System.out.println("Area del Rettangolo: " + areaR1);
		System.out.println("Perimetro del Rettangolo: " + perimetroR2);
		System.out.println("Area del Rettangolo: " + areaR2);
		System.out.println("Somma del Perimetro dei Rettangoli: " + (perimetroR1 + perimetroR2));
		System.out.println("Somma del Area dei Rettangoli: " + (areaR1 + areaR2));
	}

}
