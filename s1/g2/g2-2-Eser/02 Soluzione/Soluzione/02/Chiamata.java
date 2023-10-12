package it.epicode.exercises.week1.giorno4;

public class Chiamata {
	private String numeroChiamato;
	private int durataMinuti;
	
	
	public Chiamata(String numChiamato, int durata) {
		this.numeroChiamato = numChiamato;
		this.durataMinuti = durata;
	}
	
	
	public String getNumeroChiamato() {
		return numeroChiamato;
	}
	public void setNumeroChiamato(String numeroChiamato) {
		this.numeroChiamato = numeroChiamato;
	}
	public int getDurataMinuti() {
		return durataMinuti;
	}
	public void setDurataMinuti(int durataMinuti) {
		this.durataMinuti = durataMinuti;
	}
	
	
}
