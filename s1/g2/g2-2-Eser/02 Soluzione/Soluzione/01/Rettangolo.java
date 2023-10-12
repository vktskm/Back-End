package it.epicode.exercises.week1.giorno4;

public class Rettangolo {
	private double altezza = 0;
	private double larghezza = 0;
	
	public Rettangolo(double alt,double larg) {
		this.altezza = alt;
		this.larghezza = larg;
	}
	
	public double area() {
		return altezza * larghezza; 
	}
	
	public double perimetro() {
		return (altezza + larghezza)*2;
	}

}
