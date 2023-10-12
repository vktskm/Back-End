package Archivio;

 /*Creare le classi necessarie a gestire un catalogo bibliotecario. 
 * Il catalogo e formato da elementi che possono essere Libri o Riviste. 
 * Sia Libri che riviste hanno i seguenti attributi:
 * - Codice ISBN (codice univoco)
 * - Titolo
 * - Anno pubblicazione
 * - Numero pagine
 * I libri hanno inoltre:
 * - Autore
 * - Genere
 * Le riviste hanno:
 * - Periodicità [SETTIMANALE, MENSILE, SEMESTRALE]
 * L'archivio deve permettere le seguenti operazioni:
 * - Aggiunta di un elemento
 * - Rimozione di un elemento dato un codice ISBN
 * - Ricerca per ISBN
 * - Ricerca per anno pubblicazione
 * - Ricerca per autore
 * - salvataggio su disco dell'archivio
 * - caricamento dal disco dell'archivio
 * Per l'implementazione degli algoritmi si impieghino i Java Streams e le Lambda expression.
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Catalogo {

	static File file = new File("fileEsercizio.txt");

	public static void main(String[] args) {

		//////////////////// LISTA ARTICOLI ////////////////////
		List<Prodotto> listaProdotti = new ArrayList<Prodotto>();

		//////////////////// ISTANZE DEI LIBRI ////////////////////
		Libri adrenalina = new Libri(80729L, "Adrenalina", "2021", 316, "Zlatan Ibrahimovic", "autobiografico");
		Libri maradona = new Libri(86511L, "Maradona", "2021", 336, "Jimmy Burns","sport");
		Libri codiceDaVinci = new Libri(80920L, "Codice da Vinci", "2006", 796,"Dan Brown", "drammatico");
		Libri padreRicco = new Libri(43540L, "Padre Ricco", "TremilaMAI", 446, "Robert Kiyosaki", "economico");

		//////////////////// ISTANZE DELLE RIVISTE ////////////////////
		Riviste calcio2000 = new Riviste(99232L, "Calcio 2000", "2022", 250,Periodicita.MENSILE);
		Riviste focus = new Riviste(37347L, "Focus", "1992", 117, Periodicita.MENSILE);
		Riviste settimanaEnigmistica = new Riviste(82023L, "Settimana enigmistica", "1986", 64,Periodicita.SETTIMANALE);
		Riviste motori = new Riviste(88540L, "Motori ", "1990", 320, Periodicita.SEMESTRALE);
       
		//Aggiungi alla listaProdotti i libri
		listaProdotti.add(adrenalina);
		listaProdotti.add(maradona);
		listaProdotti.add(codiceDaVinci);
		//Aggiungi alla listaProdotti le riviste
		listaProdotti.add(calcio2000);
		listaProdotti.add(focus);
		listaProdotti.add(settimanaEnigmistica);

		// STAMPA DELLA LISTA
		stampaListaProdotti(listaProdotti); 
		// AGGIUNGE UN LIBRO ALLA LISTA
		aggiungiLibro(listaProdotti, padreRicco); 
		// AGGIUNGE UNA RIVISTA ALLA LISTA
		aggiungiRivista(listaProdotti, motori); 			
		// STAMPA DELLA LISTA DOPO AVER AGGIUNTO DUE PRODOTTI ALLA LISTA
		stampaListaProdotti(listaProdotti); 					
		//ELIMINA UN PRODOTTO DALLA LISTA PER ISBN E STAMPA DELLA LISTA DOPO LA CANCELLAZIONE
		eliminaProdottoTramiteIsbn(listaProdotti, 88540L);
		// CERCA UN PRODOTTO NELLA LISTA CON ISBN
		cercaProdottoTramiteIsbn(listaProdotti, 37347L); 
		// CERCA UN PRODOTTO NELLA LISTA CON DATA PUBBLICAZIONE
		cercaProdottoTramiteDataPub(listaProdotti, "2021");
		cercaProdottoTramiteDataPub(listaProdotti, "TremilaMAI");
		// CERCA UN PRODOTTO NELLA LISTA CON AUTORE
		cercaProdottoTramiteAutore(listaProdotti, "Dan Brown"); 	
		cercaProdottoTramiteAutore(listaProdotti, "Vincenzo Schembri"); // ERRORE CREATO APPOSITAMENTE PER VERIFICA

		////////// MANIPOLAZIONE FILE //////////
		// convertiInStringa(listaProdotti);
		scriviFile(listaProdotti);
		leggiFile();

	}

	// METODI 
	public static void stampaListaProdotti(List<Prodotto> listaProdotti) {
		listaProdotti.forEach(ele -> {
			String x = ele.getClass().toString();
			/* Viene ottenuta la classe dell'oggetto corrente utilizzando il metodo getClass() sull'istanza ele. 
			 * Viene convertita la classe in una stringa utilizzando il metodo toString(). Viene assegnata  la 
			 * stringa risultante alla variabile x. */
			
			//System.out.println(x); stampa class Archivio.Libri
			
			/*Successivamente, viene eseguito un controllo utilizzando il metodo contains() della classe String. 
			 * Se la stringa x contiene la parola "Libri", viene eseguito il blocco di codice all'interno del  primo ramo 
			 * dell'istruzione if, altrimenti viene eseguito il blocco di codice nel secondo ramo dell'istruzione if.*/
			if (x.contains("Libri")) {
				System.out.println("Libro: " + ele.getTitolo());
			} else {
				System.out.println("Rivista: " + ele.getTitolo());
			}
		});//fine forEach
		System.out.println();
		System.out.println("------------------------ FINE STAMPA LISTA ------------------------");
	}

	public static void aggiungiLibro(List<Prodotto> listaProdotti, Libri libro) {
		listaProdotti.add(libro);
		System.out.println("Libro " + libro.getTitolo());
		System.out.println();
		System.out.println("------------------------ AGGIUNGE LIBRO ------------------------");
	}

	public static void aggiungiRivista(List<Prodotto> listaProdotti, Riviste rivista) {
		listaProdotti.add(rivista);
		System.out.println("Rivista " + rivista.getTitolo());
		System.out.println();
		System.out.println("------------------------ AGGIUNGE RIVISTA ------------------------");
	}

	public static void eliminaProdottoTramiteIsbn(List<Prodotto> listaProdotti, long isbn) {
		List<Prodotto> listaSenzaElemento = listaProdotti.stream().filter(ele -> ele.getCodiceISBN() != isbn).toList();
		/* listaProdotti.stream(): Il metodo stream() viene chiamato sulla lista listaProdotti, che restituisce uno 
		 * stream di elementi della lista. Uno stream è una sequenza di elementi su cui è possibile eseguire opera-
		 * zioni di trasformazione e filtraggio.
		 * filter(ele -> ele.getCodiceISBN() != isbn):
		 * Viene applicato un filtro allo stream utilizzando il metodo filter(). L'elemento corrente dello stream viene 
		 * passato come argomento all'espressione lambda ele -> ele.getCodiceISBN() != isbn. L'espressione lambda controlla 
		 * se il codice ISBN dell'elemento corrente (ele.getCodiceISBN()) è diverso dal valore isbn specificato.
		 * .toList(): Il risultato del filtro viene raccolto in una nuova lista utilizzando il metodo toList(). 
		 * Questo metodo converte lo stream di elementi filtrati in una lista di oggetti di tipo Prodotto.
		 * In pratica, questa riga di codice filtra gli elementi della lista listaProdotti mantenendo solo quelli il cui codice 
		 * ISBN è diverso da isbn, e quindi crea una nuova lista chiamata listaSenzaElemento contenente gli elementi filtrati.*/
		
		listaProdotti.clear();//Questo metodo rimuove tutti gli elementi dalla lista listaProdotti, lasciandola vuota.
		
		listaProdotti.addAll(listaSenzaElemento);
		/* Questa istruzione aggiunge listaProdotti.addAll()tutti gli elementi dalla lista listaSenzaElemento alla lista 
		 * listaProdotti. In pratica, viene effettuata una copia degli elementi da una lista all'altra. */
		System.out.println("------------------------ ELEMENTO ELIMINATO ------------------------");
		
		if (listaProdotti.size() >= 1) {
			System.out.println();
			System.out.println("LISTA AGGIORNATA:");
			stampaListaProdotti(listaProdotti);
		} else {
			System.out.println("LA LISTA E' VUOTA!");
		}
	}

	public static void cercaProdottoTramiteIsbn(List<Prodotto> listaProdotti, long isbn) {
		List<Prodotto> prodottiTrovati = listaProdotti.stream().filter(ele -> ele.getCodiceISBN() == isbn).toList();
		if (prodottiTrovati.size() >= 1) {
			prodottiTrovati.forEach(ele -> {
				String x = ele.getClass().toString();
				if (x.contains("Libri")) {
					System.out.println("Libro trovato tramite isbn (" + isbn + "): " + ele.getTitolo());
				} else {
					System.out.println("Rivista trovata tramite isbn (" + isbn + "): " + ele.getTitolo());
				}
			});
		} else {
			System.out.println("La tua ricerca tramite isbn (" + isbn + ") non ha prodotto nessun risultato!");
		}
		System.out.println();
		System.out.println("\"------------------------ ELEMENTO RICERCATO TRAMITE ISBN ------------------------");
		
	}

	public static void cercaProdottoTramiteDataPub(List<Prodotto> listaProdotti, String annoPub) {
		List<Prodotto> prodottiTrovati = listaProdotti.stream()
				.filter(ele -> ele.getAnnoPubblicazione().equalsIgnoreCase(annoPub)).toList();
		if (prodottiTrovati.size() >= 1) {
			prodottiTrovati.forEach(ele -> {
				String x = ele.getClass().toString();
				if (x.contains("Libri")) {
					System.out.println(
							"Libro trovato tramite data di pubblicazione (" + annoPub + "): " + ele.getTitolo());
				} else {
					System.out.println(
							"Rivista trovata tramite data di pubblicazione (" + annoPub + "): " + ele.getTitolo());
				}
			});
		} else {
			System.out.println(
					"La tua ricerca tramite data di pubblicazione (" + annoPub + ") non ha prodotto nessun risultato!");
		}
		System.out.println();
		System.out.println("\"------------------------ ELEMENTO RICERCATO TRAMITE ANNO PUBBLICAZIONE ------------------------");
	}

	public static void cercaProdottoTramiteAutore(List<Prodotto> listaProdotti, String autore) {
		List<Prodotto> prodottiTrovati = listaProdotti.stream()
				.filter(ele -> ele.getAutore().equalsIgnoreCase(autore)).toList();
		if (prodottiTrovati.size() >= 1) {
			prodottiTrovati.forEach(ele -> {
				// FATTO SOLO PER I LIBRI PERCHE' LE RIVISTE NON HANNO ATTRIBUTO AUTORE
				System.out.println("Libro trovato tramite autore (" + autore + "): " + ele.getTitolo());
			});
		} else {
			System.out.println("La tua ricerca tramite l'autore (" + autore + ") non ha prodotto nessun risultato!");
		}
		System.out.println();
		System.out.println("------------------------ ELEMENTO RICERCATO TRAMITE AUTORE -----------------------");

	}

	public static void scriviFile(List<Prodotto> listaProdotti) {
		/* Il metodo scriviFile è dichiarato come public static, il che significa che può essere chiamato da qualsiasi 
		 * parte del codice senza dover istanziare un oggetto della classe che lo contiene.
		 * Il metodo richiede una lista di oggetti Prodotto come parametro, che viene chiamata listaProdotti.
		 * Il blocco di codice try indica che verrà tentata l'esecuzione delle istruzioni all'interno di esso. 
		 * Se si verifica un'eccezione di tipo IOException, il blocco catch successivo sarà eseguito per gestire l'errore.
		 * All'interno del blocco try, viene chiamato il metodo writeLines della classe FileUtils per scrivere le righe della 
		 * lista listaProdotti su un file specificato. Il file deve essere stato precedentemente inizializzato con il nome file. 
		 * Il parametro "UTF-8" indica che il file sarà codificato in UTF-8.
		 * Dopo la scrittura del file, viene stampato un messaggio sulla console usando System.out.println per indicare che la 
		 * scrittura del file è stata eseguita con successo.
		 * Se si verifica un'eccezione di tipo IOException durante la scrittura del file, il blocco catch viene eseguito. Viene 
		 * stampato un messaggio sulla console per indicare che si è verificato un errore durante la scrittura del file.
		 * Si noti che il codice fornito non include la dichiarazione e l'inizializzazione della variabile file. Pertanto, sarà 
		 * necessario dichiarare e inizializzare correttamente questa variabile all'interno del metodo scriviFile o passarla come 
		 * parametro al metodo. 
		 * Inoltre, sarà necessario importare la classe FileUtils all'inizio del file Java per utilizzarla correttamente.*/
		
		try {
			FileUtils.writeLines(file, "UTF-8", listaProdotti);
			System.out.println();
			System.out.println("------------- SCRITTURA FILE ESEGUITA------------------");
		} catch (IOException e) {
			System.out.println();
			System.out.println("------------- ERRORE SCRITTURA FILE -------------------");
		}
	}

	public static void leggiFile() {
		/* Il metodo leggiFile è dichiarato come public static, il che significa che può essere chiamato da qualsiasi parte del 
		 * codice senza dover istanziare un oggetto della classe che lo contiene.
		 * Il blocco di codice try-with-resources viene utilizzato per gestire l'apertura e la chiusura delle risorse che implementano 
		 * l'interfaccia AutoCloseable. In questo caso, viene aperto un InputStream per leggere il contenuto del file di testo.
		 * All'interno del blocco try, viene eseguito il codice per la lettura del file. Viene stampato un messaggio sulla console per 
		 * indicare che è in corso la lettura del file.
		 * Viene utilizzato il metodo IOUtils.toString per leggere il contenuto dell'input stream e convertirlo in una stringa. 
		 * Il parametro "UTF-8" indica che il file di testo è codificato in UTF-8.
		 * Dopo aver letto il contenuto del file, viene stampato sulla console il suo contenuto utilizzando System.out.println.
		 * Infine, viene stampato un messaggio sulla console per indicare che la lettura del file è stata eseguita con successo.
		 * Se si verifica un'eccezione di tipo IOException durante la lettura del file, il blocco catch viene eseguito. Viene stampato 
		 * un messaggio sulla console per indicare che si è verificato un errore durante la lettura del file.
		 * Si noti che il codice fornito fa riferimento al file "fileEsercizio.txt" come input da leggere. Assicurarsi che il file esista 
		 * nella directory corretta o fornire il percorso completo del file, se si trova in una posizione diversa. Inoltre, sarà necessario 
		 * importare le classi InputStream, FileInputStream e IOUtils all'inizio del file Java per utilizzarle correttamente.*/
		try (InputStream input = new FileInputStream("fileEsercizio.txt")) {
			System.out.println("Lettura del file di testo: ");
			System.out.println(IOUtils.toString(input, "UTF-8"));
			System.out.println("-------------- LETTURA FILE ESEGUITA ----------------");
		} catch (IOException e) {
			System.out.println();
			System.out.println("--------------- ERRORE LETTURA FILE -----------------");
		}
	}
}