package entities;

public class Riviste extends Editoria{
	
	private Periodicita periodicita;
	
	
	public Riviste(String ISBN, String titolo, long annoPub, long pagine, Periodicita periodicita) {
		
		super(ISBN, titolo, annoPub, pagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}
	
	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	
	@Override
	public String toString() {
	    return super.toString() + ", Periodicita' " + periodicita ;
	}
	
	public static String toStrFile(Riviste rivista) {
		/* Le istruzioni fornite rappresentano il metodo Java toStringFile che accetta un oggetto Rivista come parametro 
		 * e restituisce una stringa che rappresenta le informazioni della rivista in un formato specifico. 
		 * Ecco una spiegazione delle istruzioni:
		 * Rivista.class.getSimpleName(): 
		 * Questa chiamata restituisce il nome semplice della classe Rivista, cioè il nome della classe senza il package. 
		 * Serve a identificare il tipo di elemento, nel caso specifico, il tipo di oggetto Rivista.
		 * + "@" + rivista.isbn: Concatena il carattere "@" con il valore dell'attributo isbn dell'oggetto rivista. 
		 * L'attributo isbn rappresenta il codice identificativo della rivista.
		 * + "@" + rivista.titolo: Concatena il carattere "@" con il valore dell'attributo titolo dell'oggetto rivista. 
		 * L'attributo titolo rappresenta il titolo della rivista.
		 * + "@" + rivista.annoPubblicazione: Concatena il carattere "@" con il valore dell'attributo annoPubblicazione 
		 * dell'oggetto rivista. L'attributo annoPubblicazione rappresenta l'anno di pubblicazione della rivista.
		 * + "@" + rivista.numeroPagine: Concatena il carattere "@" con il valore dell'attributo numeroPagine dell'oggetto 
		 * rivista. L'attributo numeroPagine rappresenta il numero di pagine della rivista.
		 * + "@" + rivista.periodicita: Concatena il carattere "@" con il valore dell'attributo periodicita dell'oggetto 
		 * rivista. L'attributo periodicita rappresenta la frequenza di pubblicazione della rivista.
		 * Infine, viene restituita la stringa ottenuta dalla concatenazione di tutti questi valori separati da "@". 
		 * Questa stringa rappresenta le informazioni della rivista nel formato specificato dal metodo toStringFile.*/
		return Riviste.class.getSimpleName()  // Serve per identificare il tipo di elemento
				+ "@" + rivista.ISBN
				+ "@" + rivista.titolo
				+ "@" + rivista.annoPub
				+ "@" + rivista.pagine
				+ "@" + rivista.periodicita;
	}

	public static Riviste fromStrFile(String stringFile) {
		/* Il codice fornito rappresenta un metodo Java chiamato fromStringFile che accetta una stringa stringFile 
		 * come parametro e restituisce un oggetto Rivista basato sulle informazioni presenti nella stringa. 
		 * Ecco una spiegazione delle istruzioni all'interno del metodo:
		 * String[] split = stringFile.split("@");: Divide la stringa stringFile in sottostringhe utilizzando il 
		 * carattere "@" come delimitatore. 
		 * Questo crea un array di stringhe chiamato split, in cui ogni elemento corrisponde a una parte separata 
		 * della stringa originale.
		 * Periodicita periodicita = Periodicita.valueOf(split[5]);: 
		 * Utilizzando il valore split[5] dell'array split, viene convertita una stringa in un valore dell'enumerazione 
		 * Periodicita. Presumibilmente, Periodicita è un'enumerazione che rappresenta la frequenza di pubblicazione della rivista. La chiamata Periodicita.valueOf(split[5]) restituirà il valore corrispondente all'elemento dell'enumerazione che corrisponde alla stringa split[5].
		 * return new Rivista(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), periodicita);: 
		 * Crea un nuovo oggetto Rivista utilizzando i valori estratti dall'array split e l'oggetto periodicita. 
		 * La sequenza degli elementi dell'array corrisponde all'ordine in cui sono stati concatenati nell'implementazione 
		 * del metodo toStringFile.
		 * split[1] rappresenta l'ISBN della rivista.
		 * split[2] rappresenta il titolo della rivista.
		 * Integer.valueOf(split[3]) converte la sottostringa split[3] in un valore intero e rappresenta l'anno di pubblicazione 
		 * della rivista.
		 * Integer.valueOf(split[4]) converte la sottostringa split[4] in un valore intero e rappresenta il numero di pagine 
		 * della rivista.
		 * periodicita rappresenta la frequenza di pubblicazione della rivista, ottenuta dall'enumerazione Periodicita.
		 * I valori estratti vengono utilizzati per inizializzare un nuovo oggetto Rivista, che viene restituito dal metodo.
		 * Quindi, il metodo fromStringFile converte una stringa nel formato specificato dal metodo toStringFile in un oggetto 
		 * Rivista utilizzando le informazioni presenti nella stringa. Si presuppone che l'enumerazione Periodicita sia definita 
		 * correttamente per rappresentare la frequenza di pubblicazione della rivista.*/
			
		String[] split = stringFile.split("@");
		Periodicita periodicita = Periodicita.valueOf(split[5]);
		
		return new Riviste(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), periodicita);
	}
	
}
