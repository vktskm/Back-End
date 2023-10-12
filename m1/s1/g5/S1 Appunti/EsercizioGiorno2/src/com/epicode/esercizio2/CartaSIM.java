package com.epicode.esercizio2;

public class CartaSIM {
	
	String numeroTelefono;
	double credito;
	Chiamata[] listaChiamate;
	double costoChiamata = 0.20;
	
	public CartaSIM(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
		this.credito = 0;
		this.listaChiamate = new Chiamata[5];
	}
	
	public void ricaricaSim(double importo) {
		this.credito += importo;
	}
	
	public void effettuaChiamata(String numeroDaChiamare, double durata) {
		if(this.credito <= 0) {
			System.out.println("Credito non diponibile!");
		} else {
			for (int i = 0; i < listaChiamate.length; i++) {
				if(this.listaChiamate[i] == null) {
					this.listaChiamate[i] = new Chiamata(numeroDaChiamare, durata);
					this.credito = this.credito - (costoChiamata * durata);
					break;
				}
			}
			
			System.out.println("Chiamata effettuata sul numero " + numeroDaChiamare);
		}
	}
	
	public void stampaDatiSIM() {
		System.out.println("**** Dati SIM ****");
		System.out.println("Numero SIM: " + this.numeroTelefono);
		System.out.println("Credito : " + this.credito);
		System.out.println("Lista ultime 5 chiamate:");
		for (int i = 0; i < listaChiamate.length; i++) {
			if(listaChiamate[i] != null) {	
				System.out.println(listaChiamate[i].numeroChiamato + " durata: " + listaChiamate[i].durata);
			}
		}
	}


}
