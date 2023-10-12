package main.esercizio2;

/*Esercizio2
 * E' necessario scrivere una applicazione che simula il funzionamento di un frammento del 
 * sistema informativo di un operatore di telefonia cellulare.
 * Si devono quindi rappresentare i dati relativi ad una carta SIM ed in particolare:
 * - il numero di telefono
 * - il credito disponibile in euro
 * - la lista delle ultime 5 chiamate effettuate.
 * Per ciscuna chiamata deve essere rappresentata la durata in minuti e il numero chiamato. 
 * La classe SIM dovra' fornire le seguenti funzionalita':
 * - un costruttore che crea una SIM con numero di telefono passatto come parametro , credito
 * a 0 e lista delle chiamate vuota.
 * - una funzione per la stampa dei dati della Sim.
 * Scrivere un main che crei una istanza di Sim e nestampi i dati.
 * */



public class MainTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sim sim = new Sim(345689) ;
		
		sim.printPhoneData(sim);
	}

}
