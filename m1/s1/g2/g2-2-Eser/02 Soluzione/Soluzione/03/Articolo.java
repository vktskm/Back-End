package it.epicode.exercises.week1.giorno4;

public class Articolo {
	private String codice;
	private String descrizione;
	private double prezzo;
	
	// Attributo statico
	private static int numeroPezziInMagazzino;
	
	public Articolo() {
		// Costruttore vuoto
	}
	
	public Articolo(String codice, String descrizione, double prezzo){
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		
	}
	
	

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	public static int getNumeroPezziInMagazzino() {
		return numeroPezziInMagazzino;
	}



	public static void setNumeroPezziInMagazzino(int numeroPezziInMagazzino) {
		Articolo.numeroPezziInMagazzino = numeroPezziInMagazzino;
	}
}
