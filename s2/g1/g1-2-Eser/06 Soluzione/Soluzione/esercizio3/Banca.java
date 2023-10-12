package it.epicode.exercises.week3.giorno1.esercizio3;

public class Banca {

	public static void main(String args[]) {
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);
		conto1.preleva(1750.5);
		System.out.println(conto1.restituisciSaldo());
		ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);
		conto2.stampaSaldo();
		conto2.preleva(2000);
	}
}