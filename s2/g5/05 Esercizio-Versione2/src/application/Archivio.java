package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.io.FileUtils;

import entities.Editoria;
import entities.Libri;
import entities.Periodicita;
import entities.Riviste;

public class Archivio {

	public static Logger logger = LoggerFactory.getLogger(Archivio.class);
	
	private static File file = new File("info.txt");
	
	public static void main(String[] args) {
		
		//CREAZIONE LIBRI
		Libri libro1 = new Libri("9788865181901l", "Harry Potter 1", 1997, 304, "J. K. Rowling", "Fantasy");  
		Libri libro2 = new Libri("9788865181902l", "Harry Potter 2", 1998, 224, "J. K. Rowling", "Fantasy");  
		Libri libro3 = new Libri("9788865181903l", "Il Signore degli anelli 1", 1955, 500, "J. R. R. Tolkien", "Fantasy");  
		Libri libro4 = new Libri("9788865181904l", "Il Signore degli anelli 2", 2000, 600, "J. R. R. Tolkien", "Fantasy");  
		
		//CREAZIONE RIVISTE
		Riviste rivista1 = new Riviste("9788865181905l", "Focus", 1992, 130, Periodicita.Mensile);
		Riviste rivista2 = new Riviste("9788865181906l", "Vanity Fair", 1913, 120,Periodicita.Settimanale);
		Riviste rivista3 = new Riviste("9788865181907l", "L'Indice dei libri del mese", 1984, 160, Periodicita.Semestrale);
		Riviste rivista4 = new Riviste("9788865181908l", "Foreign Policy", 1970, 120, Periodicita.Semestrale);
		
		try {
			addElement(libro1);
			addElement(libro2);
			addElement(libro3);
			addElement(libro4);
			addElement(rivista1);
			addElement(rivista2);
			addElement(rivista3);
			addElement(rivista4);
			//addElement(rivista4); Verifica se la Rivista è presente e lancia una eccezione
			deleteByISBN("9788865181908l");
			saveOnDisk();
			readByDisk();
			
			} catch (IOException e) {
			
				logger.error("Errore!" + e);
			}
		
		printArchivio();
		searchByISBN("9788865181902l");
		searchByYear(1913);
		searchByAut("J. K. Rowling");
		
	}
	
	//CREO UN ARCHIVIO GENERALE
	static Map<String, Editoria> archivio = new HashMap<String, Editoria>();
	/* La parola chiave static indica che la variabile archivio è associata alla classe in cui è dichiarata, 
	 * anziché a istanze specifiche della classe. Ciò significa che può essere acceduta e utilizzata senza 
	 * dover creare un'istanza della classe.
	 * Map<String, Editoria> specifica il tipo della variabile archivio. In questo caso, è una mappa in cui 
	 * le chiavi sono di tipo String e i valori sono di tipo Editoria. Una mappa associa una chiave a un 
	 * valore, consentendo di recuperare il valore corrispondente utilizzando la chiave.
	 * Archivio è il nome della variabile. Puoi accedere a questa mappa utilizzando il nome archivio seguito 
	 * dall'operatore di accesso al punto (.) seguito da metodi e operazioni disponibili per le mappe, come 
	 * put(), get(), remove(), ecc.
	 * new HashMap<String, Editoria>() è l'inizializzazione della mappa archivio con una nuova istanza di 
	 * HashMap parametrizzata con String come tipo delle chiavi e Editoria come tipo dei valori. HashMap è 
	 * un'implementazione di Map che utilizza una tabella hash per archiviare i dati.
	 * In sintesi, il codice dichiara una variabile statica archivio che rappresenta una mappa che associa 
	 * stringhe (String) a oggetti di tipo Editoria. Puoi utilizzare questa mappa per archiviare e accedere 
	 * agli oggetti Editoria utilizzando le stringhe corrispondenti come chiavi.
	 **/

	public static void printArchivio() {
	/*  Il metodo printArchivio è dichiarato come public static, il che significa che può essere chiamato da 
	 *  qualsiasi parte del codice senza dover istanziare un oggetto della classe che lo contiene.
	 *  Il blocco di codice for-each viene utilizzato per iterare attraverso gli elementi della mappa archivio. 
	 *  archivio.entrySet() restituisce un insieme (Set) di oggetti Map.Entry, che rappresentano le coppie 
	 *  chiave-valore presenti nella mappa.
	 *  Map.Entry<String, Editoria> entry è una variabile locale dichiarata nel ciclo for-each che rappresenta 
	 *  una singola coppia chiave-valore presente nella mappa archivio.
	 *  logger.info("Archivio: {}", entry.getValue());
	 *  utilizza un logger per stampare il valore corrispondente alla chiave entry.getKey() nella mappa archivio. 
	 *  L'espressione {} viene utilizzata per sostituire dinamicamente il valore nella stringa di log.
	 *  Il logger utilizzato è probabilmente una variabile o un'istanza di una classe che implementa il logging, 
	 *  ad esempio la classe Logger org.slf4j.Logger. 
	 *  La chiamata al metodo info indica che il messaggio di log ha un livello di importanza "info".
	 *  In sintesi, il metodo printArchivio itera attraverso gli elementi della mappa archivio utilizzando un ciclo 
	 *  for-each e stampa i valori corrispondenti utilizzando un logger. L'output sarà generato nel log in base 
	 *  all'implementazione specifica del logger utilizzato.
	 **/
		
	    for (Map.Entry<String, Editoria> entry : archivio.entrySet()) {
	        logger.info("Archivio: {}", entry.getValue());
	    }
	}

	public static void addElement(Editoria elemento) throws IOException {
		
	/* Il metodo addElement è dichiarato come public static, il che significa che può essere chiamato da qualsiasi 
	 * parte del codice senza dover istanziare un oggetto della classe che lo contiene.
	 * Il metodo richiede un parametro di tipo Editoria chiamato elemento, che rappresenta l'elemento che si desi-
	 * dera aggiungere all'archivio.
	 * La clausola throws IOException indica che il metodo può generare un'eccezione di tipo IOException, che deve 
	 * essere gestita o propagata al chiamante del metodo.
	 * archivio.containsKey(elemento.getISBN()) verifica se la chiave elemento.getISBN() esiste già nella mappa 
	 * archivio. containsKey restituisce true se la chiave è presente, altrimenti restituisce false.
	 * Se la chiave elemento.getISBN() esiste già nell'archivio, viene generata un'eccezione di tipo IOException 
	 * con il messaggio "Elemento già presente nell'archivio". L'eccezione viene lanciata per indicare che 
	 * l'operazione di aggiunta non può essere completata perché l'elemento è già presente.
	 * Se la chiave elemento.getISBN() non esiste nell'archivio, il metodo archivio.put(elemento.getISBN(),elemento) 
	 * viene chiamato per inserire l'elemento nella mappa archivio. put associa la chiave elemento.getISBN() al 
	 * valore elemento nella mappa.
	 * In sintesi, il metodo addElement controlla se una determinata chiave (elemento.getISBN()) esiste già 
	 * nell'archivio. Se la chiave è già presente, viene generata un'eccezione di tipo IOException. Altrimenti, 
	 * l'elemento viene aggiunto all'archivio utilizzando la chiave e il valore corrispondenti nella mappa.
	 * */
		if (archivio.containsKey(elemento.getISBN())) {
	        throw new IOException("Elemento già presente nell'archivio");
	    }
	    archivio.put(elemento.getISBN(), elemento);
	}

	public static void deleteByISBN(String ISBN) throws IOException {
	/* Il metodo deleteByISBN è dichiarato come public static, il che significa che può essere chiamato da qualsiasi 
	 * parte del codice senza dover istanziare un oggetto della classe che lo contiene.
	 * Il metodo richiede un parametro di tipo String chiamato ISBN, che rappresenta la chiave ISBN dell'elemento che 
	 * si desidera rimuovere dall'archivio.
	 * La clausola throws IOException indica che il metodo può generare un'eccezione di tipo IOException, che deve 
	 * essere gestita o propagata al chiamante del metodo.
	 * archivio.containsKey(ISBN) verifica se la chiave ISBN esiste nell'archivio rappresentato dalla mappa archivio. 
	 * containsKey restituisce true se la chiave è presente, altrimenti restituisce false.
	 * Se la chiave ISBN non esiste nell'archivio, viene generata un'eccezione di tipo IOException con il messaggio 
	 * "Elemento non presente nell'archivio". L'eccezione viene lanciata per indicare che l'operazione di eliminazione 
	 * non può essere completata perché l'elemento con la chiave specificata non è presente nell'archivio.
	 * Se la chiave ISBN esiste nell'archivio, il metodo archivio.remove(ISBN) viene chiamato per rimuovere l'elemento 
	 * corrispondente alla chiave dalla mappa archivio. remove elimina l'associazione chiave-valore dalla mappa.
	 * In sintesi, il metodo deleteByISBN controlla se una determinata chiave (ISBN) esiste nell'archivio. Se la chiave 
	 * non è presente, viene generata un'eccezione di tipo IOException. 
	 * Altrimenti, l'elemento associato alla chiave viene rimosso dall'archivio utilizzando il metodo remove.*/
	    if (!archivio.containsKey(ISBN)) {
	        throw new IOException("Elemento non presente nell'archivio");
	    }
	    archivio.remove(ISBN);
	}

	public static Editoria searchByISBN(String ISBN) {
	/* Il metodo searchByISBN è dichiarato come public static, il che significa che può essere chiamato da qualsiasi 
	 * parte del codice senza dover istanziare un oggetto della classe che lo contiene.
	 * Il metodo richiede un parametro di tipo String chiamato ISBN, che rappresenta la chiave ISBN dell'elemento che 
	 * si desidera cercare nell'archivio.
	 * Viene dichiarata una variabile locale result di tipo Editoria e viene assegnato il valore associato alla chiave 
	 * ISBN nell'archivio utilizzando il metodo get della mappa archivio. Se la chiave ISBN è presente nell'archivio, 
	 * result conterrà l'elemento corrispondente; altrimenti, result sarà null.
	 * logger.info("Risultato ricerca per ISBN({}): {}", ISBN, result); utilizza un logger per stampare il risultato 
	 * della ricerca. La stringa di log contiene il valore della chiave ISBN (ISBN) e il valore dell'elemento 
	 * corrispondente trovato (result).
	 * Il valore result viene restituito come risultato della ricerca utilizzando l'istruzione return result.
	 * In sintesi, il metodo searchByISBN cerca un elemento nell'archivio utilizzando la chiave ISBN fornita come 
	 * parametro. Restituisce l'elemento corrispondente se la chiave è presente nell'archivio, altrimenti restituisce 
	 * null. Inoltre, il metodo stampa il risultato della ricerca utilizzando un logger.*/
	    Editoria result = archivio.get(ISBN);
	    logger.info("Risultato ricerca per ISBN({}): {}", ISBN, result);
	    return result;
	}


	public static List<Editoria> searchByYear(long anno) {
		
	/* Il metodo searchByYear è dichiarato come public static, il che significa che può essere chiamato da qualsiasi parte 
	 * del codice senza dover istanziare un oggetto della classe che lo contiene.
	 * Il metodo richiede un parametro di tipo long chiamato anno, che rappresenta l'anno di pubblicazione degli elementi 
	 * che si desidera cercare nell'archivio.
	 * Viene dichiarata una variabile locale result di tipo List<Editoria>, inizializzata con una nuova istanza di 
	 * ArrayList<Editoria>. Questa lista conterrà gli elementi che corrispondono all'anno di pubblicazione.
	 * Il blocco for-each viene utilizzato per iterare attraverso gli elementi della mappa archivio. archivio.entrySet() 
	 * restituisce un insieme (Set) di oggetti Map.Entry, che rappresentano le coppie chiave-valore presenti nella mappa.
	 * Map.Entry<String, Editoria> entry è una variabile locale dichiarata nel ciclo for-each che rappresenta una singola 
	 * coppia chiave-valore presente nella mappa archivio.
	 * La condizione entry.getValue().getAnnoPub() == anno verifica se l'elemento corrispondente alla chiave entry.getKey() 
	 * ha l'anno di pubblicazione uguale al valore anno passato come parametro. Se la condizione è vera, l'elemento viene 
	 * aggiunto alla lista result utilizzando il metodo add.logger.info("Per questo anno in archivio abbiamo: {}", result); 
	 * utilizza un logger per stampare il risultato della ricerca. La stringa di log contiene la lista degli elementi che 
	 * corrispondono all'anno di pubblicazione.
	 * La lista result viene restituita come risultato della ricerca utilizzando l'istruzione return result.
	 * In sintesi, il metodo searchByYear cerca gli elementi nell'archivio che corrispondono all'anno di pubblicazione 
	 * fornito come parametro. Restituisce una lista contenente gli elementi trovati e stampa il risultato della ricerca 
	 * utilizzando un logger.*/
		
	    List<Editoria> result = new ArrayList<Editoria>();
	    for (Map.Entry<String, Editoria> entry : archivio.entrySet()) {
	        if (entry.getValue().getAnnoPub() == anno) {
	            result.add(entry.getValue());
	        }
	    }
	    logger.info("Per questo anno in archivio abbiamo: {}", result);
	    return result;
	}

	public static List<Editoria> searchByAut(String autore) {
		
	/* Il metodo searchByAut è dichiarato come public static, il che significa che può essere chiamato da qualsiasi parte del 
	 * codice senza dover istanziare un oggetto della classe che lo contiene.
	 * Il metodo richiede un parametro di tipo String chiamato autore, che rappresenta l'autore degli elementi che si desidera 
	 * cercare nell'archivio.
	 * Viene dichiarata una variabile locale result di tipo List<Editoria>, inizializzata con una nuova istanza di 
	 * ArrayList<Editoria>. Questa lista conterrà gli elementi che corrispondono all'autore di riferimento.
	 * Il blocco for-each viene utilizzato per iterare attraverso gli elementi della mappa archivio. archivio.entrySet() 
	 * restituisce un insieme (Set) di oggetti Map.Entry, che rappresentano le coppie chiave-valore presenti nella mappa.
	 * Map.Entry<String, Editoria> entry è una variabile locale dichiarata nel ciclo for-each che rappresenta una singola 
	 * coppia chiave-valore presente nella mappa archivio.
	 * La condizione entry.getValue() instanceof Libri verifica se il valore corrispondente alla chiave entry.getKey() è 
	 * un'istanza della classe Libri. Questo controllo è utile per filtrare solo gli elementi di tipo Libri dall'archivio.
	 * Se l'elemento è un'istanza di Libri, viene effettuato il casting del valore a Libri utilizzando l'operatore (Libri) 
	 * entry.getValue(). Questo permette di accedere ai metodi specifici della classe Libri.
	 * La condizione libro.getAutore().equals(autore) verifica se l'autore del libro corrisponde al valore autore passato 
	 * come parametro. Se la condizione è vera, il libro viene aggiunto alla lista result utilizzando il metodo add.
	 * logger.info("Risultato ricerca per {}: ", autore); utilizza un logger per stampare il risultato della ricerca. 
	 * La stringa di log contiene il messaggio di ricerca per l'autore specificato.
	 * Il ciclo for-each successivo itera attraverso gli elementi nella lista result e utilizza il logger per stampare ogni elemento.
	 * La lista result viene restituita come risultato della ricerca utilizzando l'istruzione return result.
	 * In sintesi, il metodo searchByAut cerca gli elementi nell'archivio che corrispondono all'autore fornito come parametro. 
	 * Restituisce una lista contenente gli elementi trovati e stampa il risultato della ricerca utilizzando un logger. 
	 * L'implementazione specifica fa uso della classe Libri e del metodo getAutore() per ottenere l'autore degli elementi filtrati.
	 * */
	    List<Editoria> result = new ArrayList<Editoria>();
	    for (Map.Entry<String, Editoria> entry : archivio.entrySet()) {
	        if (entry.getValue() instanceof Libri) {
	            Libri libro = (Libri) entry.getValue();
	            if (libro.getAutore().equals(autore)) {
	                result.add(libro);
	            }
	        }
	    }
	    logger.info("Risultato ricerca per {}: ", autore);
	    for(Editoria elemento : result) {
	        logger.info("{}", elemento);
	    }
	    return result;
	}

	
	//SCRITTURA SU FILE DI TESTO
	public static void saveOnDisk() throws IOException {
	/*  Il metodo saveOnDisk è dichiarato come public static, il che significa che può essere chiamato da qualsiasi 
	 * parte del codice senza dover istanziare un oggetto della classe che lo contiene.
	 * La clausola throws IOException indica che il metodo può generare un'eccezione di tipo IOException, che deve 
	 * essere gestita o propagata al chiamante del metodo.
	 * Viene dichiarata una variabile locale di tipo String chiamata str e inizializzata come una stringa vuota. 
	 * Questa variabile conterrà la rappresentazione testuale degli elementi dell'archivio.
	 * Il blocco for-each viene utilizzato per iterare attraverso i valori della mappa archivio utilizzando il metodo
	 *  values(). Questo permette di accedere a ogni elemento presente nell'archivio.
	 *  Se la lunghezza della stringa str è diversa da 0, viene aggiunto il carattere "#" alla stringa str. 
	 *  Questo viene fatto per separare i diversi elementi dell'archivio nella stringa finale.
	 *  La struttura if-else verifica il tipo dell'elemento utilizzando l'operatore instanceof. Se l'elemento è un'istanza 
	 *  della classe Libri, viene chiamato il metodo statico toStrFile della classe Libri per ottenere la rappresentazione 
	 *  testuale dell'elemento. Se l'elemento è un'istanza della classe Riviste, viene chiamato il metodo statico toStrFile 
	 *  della classe Riviste per ottenere la rappresentazione testuale dell'elemento.
	 *  La rappresentazione testuale dell'elemento viene aggiunta alla stringa str.
	 *  Viene utilizzato il metodo writeStringToFile della classe FileUtils per scrivere la stringa str sul file specificato 
	 *  (file) utilizzando la codifica "UTF-8".
	 *  logger.info("Archivio salvato correttamente sul file " + file); utilizza un logger per stampare un messaggio che conferma 
	 *  che l'archivio è stato salvato correttamente sul file specificato.
	 *  In sintesi, il metodo saveOnDisk converte gli elementi dell'archivio in una rappresentazione testuale e li salva su un 
	 *  file specificato. Utilizza una stringa str per accumulare la rappresentazione testuale degli elementi, separandoli con 
	 *  il carattere "#". Infine, la stringa viene scritta sul file specificato e viene generato un messaggio di log per 
	 *  confermare il salvataggio.*/
	    String str = "";
	    for (Editoria elemento : archivio.values()) {
	        if (str.length() != 0) {
	            str += "#";
	        }
	        if (elemento instanceof Libri) {
	            str += Libri.toStrFile((Libri) elemento);
	        } else if (elemento instanceof Riviste) {
	            str += Riviste.toStrFile((Riviste) elemento);
	        }
	    }
	    FileUtils.writeStringToFile(file, str, "UTF-8");
	    logger.info("Archivio salvato correttamente sul file " + file);
	}

	
	//LETTURA DA FILE DI TESTO
	public static void readByDisk() throws IOException {
	/* Il metodo readByDisk è dichiarato come public static, il che significa che può essere chiamato da qualsiasi 
	 * parte del codice senza dover istanziare un oggetto della classe che lo contiene.
	 * La clausola throws IOException indica che il metodo può generare un'eccezione di tipo IOException, che deve 
	 * essere gestita o propagata al chiamante del metodo.
	 * Viene chiamato il metodo clear sulla mappa archivio per rimuovere tutti gli elementi presenti nell'archivio.
	 * Viene utilizzato il metodo readFileToString della classe FileUtils per leggere il contenuto del file specificato 
	 * (file) come una stringa utilizzando la codifica "UTF-8". Il risultato viene assegnato alla variabile str.
	 * La stringa str viene suddivisa utilizzando il carattere "#" come delimitatore, e il risultato viene convertito in una 
	 * lista di stringhe utilizzando il metodo asList della classe Arrays. Il risultato viene assegnato alla lista splitStr.
	 * Il blocco for-each viene utilizzato per iterare attraverso le stringhe nella lista splitStr. Ogni stringa rappresenta 
	 * la rappresentazione testuale di un elemento dell'archivio.
	 * Viene dichiarata una variabile element di tipo Editoria e inizializzata come null.
	 * La struttura if-else verifica se la stringa newStr inizia con il nome semplice della classe Libri o Riviste, 
	 * utilizzando il metodo startsWith della classe String. Se la condizione è vera, viene chiamato il metodo
	 *  statico fromStrFile della rispettiva classe (Libri o Riviste) per creare un oggetto Editoria a partire dalla 
	 *  rappresentazione testuale. L'oggetto risultante viene assegnato alla variabile element.
	 *  Se la variabile element non è null, viene utilizzato il metodo put della mappa archivio per aggiungere l'elemento 
	 *  all'archivio utilizzando la chiave element.getISBN() e il valore element.
	 *  Viene chiamato il metodo printArchivio per stampare gli elementi presenti nell'archivio.
	 *  logger.info("Archivio caricato correttamente dal file " + file); utilizza un logger per stampare un messaggio che 
	 *  conferma che l'archivio è stato caricato correttamente dal file specificato.
	 *  In sintesi, il metodo readByDisk legge il contenuto di un file specificato come stringa, divide la stringa in base 
	 *  al carattere "#", crea gli oggetti Editoria corrispondenti alla rappresentazione testuale delle stringhe e li aggiunge
	 *   all'archivio. Infine, vengono stampati gli elementi presenti nell'archivio e viene generato un messaggio di log per 
	 *   confermare il caricamento.*/
	    archivio.clear();
	    String str = FileUtils.readFileToString(file, "UTF-8");
	    List<String> splitStr = Arrays.asList(str.split("#"));
	    for (String newStr : splitStr) {
	        Editoria element = null;
	        if (newStr.startsWith(Libri.class.getSimpleName())) {
	            element = Libri.fromStrFile(newStr);
	        } else if (newStr.startsWith(Riviste.class.getSimpleName())) {
	            element = Riviste.fromStrFile(newStr);
	        }
	        if (element != null) {
	            archivio.put(element.getISBN(), element);
	        }
	    }
	    printArchivio();
	    logger.info("Archivio caricato correttamente dal file " + file);
	}


}


