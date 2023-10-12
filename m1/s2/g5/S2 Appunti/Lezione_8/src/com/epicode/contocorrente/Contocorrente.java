package com.epicode.contocorrente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Contocorrente {
	
	// Saldo del contocorrente
	private double saldo;
	// Titolare del contocorrente
	private String titolare;
	
	private Logger log = LoggerFactory.getLogger(Contocorrente.class);

	public Contocorrente(String titolare) {
		// inizializzo i parametri del contocorrente
		this.titolare = titolare;
		this.saldo = 0;
	}

	public double deposito(double versamento) {
		// metodo che mi permette di versare il denare nel mio conto
		this.saldo += versamento;
		return this.saldo;
	}
	
	public synchronized double prelievo(double denaroDaPrelevare) {
		// effettuo un controllo sul denaro da prelevare e 
		//nel caso positivo prelevo ed aggiorno il saldo
		if(controlloSaldo(denaroDaPrelevare)) {
			log.info("Prelievo dal conto di " + this.titolare + " €" + denaroDaPrelevare);
			this.saldo -= denaroDaPrelevare;
		}
		return this.saldo;
	}
	
	public boolean controlloSaldo(double denaroDaPrelevare) {
		// metodo che controlla se possibile prelevare da un conto e 
		// mi restituisce un valore booleano (true o false)
		return this.saldo >= denaroDaPrelevare;
	}

	@Override
	public String toString() {
		return "Contocorrente [saldo=" + saldo + ", titolare=" + titolare + "]";
	}
	
}
