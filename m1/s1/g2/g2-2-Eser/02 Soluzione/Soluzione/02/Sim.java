package it.epicode.exercises.week1.giorno4;

public class Sim {
	private String numeroTelefono;
	private double creditoDisponibile;
	private Chiamata[] listaChiamate;
	
	
	public Sim(String numero) {
		this.numeroTelefono = numero;
		this.creditoDisponibile = 0;
		this.listaChiamate = new Chiamata[5];
		
	}
		
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public double getCreditoDisponibile() {
		return creditoDisponibile;
	}
	public void setCreditoDisponibile(double creditoDisponibile) {
		this.creditoDisponibile = creditoDisponibile;
	}
	public Chiamata[] getListaChiamate() {
		return listaChiamate;
	}
	public void setListaChiamate(Chiamata[] listaChiamate) {
		this.listaChiamate = listaChiamate;
	}
	
	public void stampaDati() {
		System.out.println("Sim: " + this.numeroTelefono);
		System.out.println("Credito disponibile: " + this.creditoDisponibile);
		System.out.println("Lista chiamate Sim: " + this.numeroTelefono);
		
		// Controlla se la chiamata è presente nella posizione indicata, altrimenti potrei avere un errore
		// in costrutto if verrà speigato in dettaglio nelle lezioni successive
		if (listaChiamate[0] != null) {
			System.out.println("- Chiamata 1: " + listaChiamate[0].getNumeroChiamato() + " - Durata minuti: " + listaChiamate[0].getDurataMinuti());
		}
		if (listaChiamate[1] != null) {
			System.out.println("- Chiamata 2: " + listaChiamate[1].getNumeroChiamato() + " - Durata minuti: " + listaChiamate[1].getDurataMinuti());
		}
		if (listaChiamate[2] != null) {
			System.out.println("- Chiamata 3: " + listaChiamate[2].getNumeroChiamato() + " - Durata minuti: " + listaChiamate[2].getDurataMinuti());
		}
		if (listaChiamate[3] != null) {
			System.out.println("- Chiamata 4: " + listaChiamate[3].getNumeroChiamato() + " - Durata minuti: " + listaChiamate[3].getDurataMinuti());
		}
		if (listaChiamate[4] != null) {
			System.out.println("- Chiamata 5: " + listaChiamate[4].getNumeroChiamato() + " - Durata minuti: " + listaChiamate[4].getDurataMinuti());
		}

	}

}
