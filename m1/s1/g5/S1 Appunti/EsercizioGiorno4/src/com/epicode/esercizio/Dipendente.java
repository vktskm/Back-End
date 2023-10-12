package com.epicode.esercizio;

public class Dipendente {
	
	private static double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;

	public Dipendente(String matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}

	public Dipendente(String matricola, double stipendio, double importoOrarioStraordinario, Livello livello,
			Dipartimento dipartimento) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}
	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	public static double getStipendioBase() {
		return stipendioBase;
	}
	public String getMatricola() {
		return matricola;
	}
	public double getStipendio() {
		return stipendio;
	}
	public Livello getLivello() {
		return livello;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Dipendente matricola: " + matricola +
							" stipendio: " + stipendio +
							" importo orario str. " + importoOrarioStraordinario + 
							" livello: " + livello +
							" dipartimento: " + dipartimento);
	}
	
	public Livello promuovi() {
		// Soluzione con IF-ELSE
//		if(this.livello == Livello.OPERAIO) {
//			// se il Dipendente è operaio lo promuove a impiegato
//			this.livello = Livello.IMPIEGATO;
//			this.stipendio = this.stipendioBase * 1.2;
//		} else if(this.livello == Livello.IMPIEGATO) {
//			// se il Dipendente è impiegato lo promuove a quadro
//			this.livello = Livello.QUADRO;
//			this.stipendio = this.stipendioBase * 1.5;
//		} else if(this.livello == Livello.QUADRO) {
//			// se il Dipendente è quadro lo promuove a dirigente
//			this.livello = Livello.DIRIGENTE;
//			this.stipendio = this.stipendioBase * 2;
//		} else {
//			// se il Dipendente è dirigente resta tale e scrive un messaggio di errore
//			System.out.println("ERRORE il dipendente non può essere promosso!!!");
//		}
		
		// Soluzione con Switch
		switch (this.livello) {
		case OPERAIO: {
			this.livello = Livello.IMPIEGATO;
			this.stipendio = this.stipendioBase * 1.2;
			break;
		}
		case IMPIEGATO: {
			this.livello = Livello.QUADRO;
			this.stipendio = this.stipendioBase * 1.5;
			break;
		}
		case QUADRO: {
			this.livello = Livello.DIRIGENTE;
			this.stipendio = this.stipendioBase * 2;
			break;
		}
		case DIRIGENTE: {
			System.out.println("ERRORE il dipendente non può essere promosso!!!");
			break;
		}
		default:
			System.out.println("ERRORE il dipendente non può essere promosso!!!");
			break;
		}
		
		return this.livello;
	}
	
	public static double calcolaPaga(Dipendente d) {
		return d.stipendio;
	}
	
	public static double calcolaPaga(Dipendente d, int numeroOreStraordinario ) {
		return d.stipendio + (numeroOreStraordinario * d.importoOrarioStraordinario);
	}

}
