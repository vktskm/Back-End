package entities;

public class Libri extends Editoria{
	
	private String autore;
	private String genere;
	
	public Libri(String ISBN, String titolo, long annoPub, long pagine, String autore, String genere) {
		
		super(ISBN, titolo, annoPub, pagine);
		this.autore = autore;
		this.genere = genere;
		
	}
	
	public String getAutore() {
		return autore;
	}
	
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	public String getGenere() {
		return genere;
	}
	
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@Override
	public String toString() {
	    return super.toString() + ", Autore: " + autore + ", Genere: " + genere;
	}
	
	public static String toStrFile(Libri libro) {
		/*Questo metodo Java toStringFile accetta un oggetto Libro come parametro e restituisce una stringa che rappresenta le 
	     * informazioni del libro in un formato specifico. Ecco una spiegazione delle istruzioni all'interno del metodo:
	     * Libro.class.getSimpleName(): Questa chiamata restituisce il nome semplice della classe Libro, cioè il nome della 
	     * classe senza il package. Serve a identificare il tipo di elemento, nel caso specifico, il tipo di oggetto Libro.
	     * + "@" + libro.isbn: Concatena il carattere "@" con il valore dell'attributo isbn dell'oggetto libro. 
	     * L'attributo isbn rappresenta il codice identificativo del libro.
	     * + "@" + libro.titolo: Concatena il carattere "@" con il valore dell'attributo titolo dell'oggetto libro. 
	     * L'attributo titolo rappresenta il titolo del libro.
	     * + "@" + libro.annoPubblicazione: Concatena il carattere "@" con il valore dell'attributo annoPubblicazione dell'oggetto 
	     * libro. L'attributo annoPubblicazione rappresenta l'anno di pubblicazione del libro.
	     * + "@" + libro.numeroPagine: Concatena il carattere "@" con il valore dell'attributo numeroPagine dell'oggetto libro. 
	     * L'attributo numeroPagine rappresenta il numero di pagine del libro.
	     * + "@" + libro.autore: Concatena il carattere "@" con il valore dell'attributo autore dell'oggetto libro. 
	     * L'attributo autore rappresenta l'autore del libro.
	     * + "@" + libro.genere: Concatena il carattere "@" con il valore dell'attributo genere dell'oggetto libro. 
	     * L'attributo genere rappresenta il genere del libro.
	     * Infine, viene restituita la stringa ottenuta dalla concatenazione di tutti questi valori separati da "@". 
	     * Questa stringa rappresenta le informazioni del libro nel formato specificato dal metodo toStringFile.*/
		return Libri.class.getSimpleName()
				+ "@" + libro.ISBN
				+ "@" + libro.titolo
				+ "@" + libro.annoPub
				+ "@" + libro.pagine
				+ "@" + libro.autore
				+ "@" + libro.genere;
	}

	public static Libri fromStrFile(String stringFile) {
		/* Questo metodo Java fromStringFile accetta una stringa stringFile come parametro e restituisce un oggetto Libro basato 
		 * sulle informazioni presenti nella stringa. Ecco una spiegazione delle istruzioni all'interno del metodo:
		 * String[] split = stringFile.split("@");: 
		 * Divide la stringa stringFile in sottostringhe utilizzando il carattere "@" come delimitatore. 
		 * Questo crea un array di stringhe chiamato split, in cui ogni elemento corrisponde a una parte separata della stringa 
		 * originale.
		 * new Libro(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5], split[6]);: 
		 * Crea un nuovo oggetto Libro utilizzando i valori estratti dall'array split. La sequenza degli elementi dell'array 
		 * corrisponde all'ordine in cui sono stati concatenati nell'implementazione del metodo toStringFile.
		 * split[1] rappresenta l'ISBN del libro.
		 * split[2] rappresenta il titolo del libro.
		 * Integer.valueOf(split[3]) converte la sottostringa split[3] in un valore intero e rappresenta l'anno di pubblicazione 
		 * del libro.
		 * Integer.valueOf(split[4]) converte la sottostringa split[4] in un valore intero e rappresenta il numero di pagine del 
		 * libro.
		 * split[5] rappresenta l'autore del libro.
		 * split[6] rappresenta il genere del libro.
		 * I valori estratti vengono utilizzati per inizializzare un nuovo oggetto Libro, che viene restituito dal metodo.
		 * Quindi, il metodo fromStringFile converte una stringa nel formato specificato dal metodo toStringFile in un oggetto 
		 * Libro utilizzando le informazioni presenti nella stringa.*/
		String[] split = stringFile.split("@");
		
		return new Libri(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5], split[6]);
	}
	

}
