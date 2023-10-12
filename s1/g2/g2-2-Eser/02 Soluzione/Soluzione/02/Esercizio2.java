package it.epicode.exercises.week1.giorno4;

public class Esercizio2 {

	public static void main(String[] args) {
		
		Sim miaSim = new Sim("+39 320 4409332");
		
		miaSim.setCreditoDisponibile(10);
		
		Chiamata chiamata = new Chiamata("+39 339 3234567", 3);
		miaSim.getListaChiamate()[0] = chiamata;
		
		// Usa la stessa variabile per un nuovo oggetto
		chiamata = new Chiamata("+39 335 234556", 5);
		miaSim.getListaChiamate()[1] = chiamata;
		
		chiamata = new Chiamata("+39 320 8832445", 7);
		miaSim.getListaChiamate()[2] = chiamata;
		
		
		miaSim.stampaDati();
	}

}
