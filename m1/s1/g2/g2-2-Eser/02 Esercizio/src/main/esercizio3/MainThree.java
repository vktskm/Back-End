package main.esercizio3;

/*Esercizio #3
 * E' necessario scrivere una applicazione che simula il funzionamento di un ecommerce.
 * Si devono quindi rappresentare i dati relativi ai seguenti elementi:
 * Articolo
 * - codice articolo
 * - descrizione articolo 
 * - prezzo
 * - numero pezzi disponibili a magazzino 
 * Cliente
 * - codice cliente
 * - nome e cognome
 * - email 
 * - data iscrizione
 * Carrello
 * - cliente associato
 * - elenco articoli
 * - totale costo articoli
 * */


import java.util.Arrays;

public class MainThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Cliente AA301 = new Cliente("AA301", "Enzo", "Licata", "enzlkt@gmail.com", "01.01.2023");
		
		Articolo occhiali = new Articolo(0001, "Occhiali ", 100, 278.99);
		Articolo pallone = new Articolo(0301, "Pallone ", 110, 78.90);
		
		Object[] elencoArticoli = { occhiali, pallone };
		double totaleCarrello = occhiali.prezzo + pallone.prezzo;
		
		Carrello carrello = new Carrello("AA301", elencoArticoli, totaleCarrello);
		
		System.out.println(toString(AA301));
		System.out.println(toString(occhiali));
		System.out.println(toString(pallone));
		System.out.println(toString(carrello));
	
	}

	private static String toString(Articolo occhiali) {
		return  "Codice: " + occhiali.codice + " " + occhiali.descrizione + " Prezzo: "  + occhiali.prezzo+ "$";
	}

	private static String toString(Cliente AA301) {
		return "Nome: " + AA301.nome + " Cognome: " +  AA301.cognome + " " + "Data di iscrizione: " + AA301.dataIscrizione;
	}
	
	private static String toString(Carrello carrello) {
		return "CodCarrello: "+carrello.cliente + Arrays.toString(carrello.elencoArticoli) + " Totale: " +carrello.totaleCarrello + "$";
	}
	

}
