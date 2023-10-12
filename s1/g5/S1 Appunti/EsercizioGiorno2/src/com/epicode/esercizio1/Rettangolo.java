package com.epicode.esercizio1;

public class Rettangolo {
	
	int altezza;
	int larghezza;
	
	public Rettangolo(int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public int calcolaPerimetro() {
		return (this.altezza *2)+(this.larghezza *2);
	}
	
	public int calcolaArea() {
		return this.larghezza  * this.altezza;
	}

}
