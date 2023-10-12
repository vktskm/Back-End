package d4;

/*Esercizio #2
 * Creare una classe Gestione Dipendenti con un main che:
 * - istanzia 4 dipendenti:
 * due operai che lavorano in produzione;
 * un impiegato che lavora in amministrazione; un dirigente che lavora nelle vendite;
 * -Promuove un operaio a impiegato e l'impiegato a quadro
 * Stampa lo stato di tutti i dipendenti
 * - Calcola la somma di tutti gli stipendi dovuti ai dipendenti comprendendo per ciascuno 
 * 5 ore di straordinario stampi l'importo
 * */


public class GestioneDipendenti {
	public static void main(String[] args) {
		Dipendente Giovanni = new Dipendente(1,Dipartimento.PRODUZIONE);
		Dipendente Marco = new Dipendente(2,Dipartimento.PRODUZIONE);
		Dipendente Paolo = new Dipendente(3, 30, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente Enzo = new Dipendente(4, 30, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		Marco.promuovi();
		Paolo.promuovi();
		
		Giovanni.stampaDatiDipendente();
		Marco.stampaDatiDipendente();
		Paolo.stampaDatiDipendente();
		Enzo.stampaDatiDipendente();
		
		calcolaPaga(Giovanni, 5);
		calcolaPaga(Marco, 5);
		calcolaPaga(Paolo, 5);
		calcolaPaga(Enzo, 5);
	}
	
	public static double calcolaPaga(Dipendente d) {
		System.out.println(d.getStipendioBase());
		return d.getStipendioBase();
	}
	public static double calcolaPaga(Dipendente d, int i) {
		System.out.println(d.getStipendioBase() + d.getImportoOrarioStraordinario() * i);
		return d.getStipendioBase() + d.getImportoOrarioStraordinario() * i;
	}

}
