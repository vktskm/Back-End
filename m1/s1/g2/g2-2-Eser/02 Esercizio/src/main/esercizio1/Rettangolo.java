package main;

public class Rettangolo {
	
	double altezza;
	double larghezza;
	
	public Rettangolo(double altezza, double larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	
	public double calcPerimetro() {
		double perimetro = (altezza+larghezza)*2;
		return perimetro;
	}
	
	
	public double calcArea() {
		double area = (altezza*larghezza);
		return area;
	}
	
	
	public static void stampaRettangolo(Rettangolo Rettangolo) {
		System.out.println("Area: " + Rettangolo.calcArea());
		System.out.println("Perimetro: " + Rettangolo.calcPerimetro());
	}
	
	
	public static void stampaDueRettangoli(Rettangolo Rettangolo, Rettangolo RettangoloDue) {
		
		System.out.println("Area uno: " + Rettangolo.calcArea());
		System.out.println("Perimetro uno: " + Rettangolo.calcPerimetro());
		
		System.out.println("Area due: " + RettangoloDue.calcArea());
		System.out.println("Perimetro due: " + RettangoloDue.calcPerimetro());
		
		System.out.println("Somma delle aree: " + (Rettangolo.calcArea() + RettangoloDue.calcArea()));
		System.out.println("Somma del perimetro: " + (Rettangolo.calcPerimetro() + RettangoloDue.calcPerimetro()));
	}
}