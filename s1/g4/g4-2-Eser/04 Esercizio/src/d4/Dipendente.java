package d4;

/*Esercizio #1
 * Scrivere la classe Dipendente che ha i seguenti attributi:
 * Attributi statici
 * - stipendioBase 
 * - numero decimale con stipendio base mensile prevalorizzato a 1000 accessibile a tutte le classi.
 * - matricola - identificativo univoco del dipendente
 * - stipendio - numero decimale con stipendio base mensile calcolato per il dipendente
 * - importoOrarioStraordinario - numero decimale con importo per ogni ora di straordinario
 * - Livello - valori possibili [OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE]
 * - Dipartimento - Valori possibili [PRODUZIONE, AMMINISTRAZIONE, VENDITE].
 * Le proprieta'  devono essere accessibili solo dalla classe Dipendente e deve essere possibile
 * leggerle tramite opportuni metodi get ma non modificarle, tranne le proprieta' Dipartimento e 
 * importoOrarioStraordinario che possono essere modificate da altre classi tramite un metodo di set.
 * Definire due costruttori: 
 * - uno che accetti solo la matricola e Dipartimento ed imposti i seguenti valori
 * - stipendio = stipendioBase
 * - importoOrarioStraordinario = 30
 * - Livello = OPERAIO
 * - Uno che accetti tutti i parametri
 * Definire i seguenti metodi
 * - stampaDatiDipendente 
 * - Stampa i dati del dipendente
 * - promuovi 
 * - aggiorna il livello del dipendente con la seguente logica 
 * se il Dipendente è operaio lo promuove a impiegato
 * se il Dipendente è impiegato lo promuove a quadro
 * se il Dipendente è quadro lo promuove a dirigente
 * se il Dipendente è dirigente resta tale e scrive un messaggio di errore
 * Il metodo aggiorna inoltre lo stipendio del dipendente con la seguente logica
 * - IMPIEGATO = stipendioBase * 1,2
 * - QUADRO = stipendioBase * 1,5
 *  DIRIGENTE = stipendioBase * 2
 *  Infine il metodo ritorna il nuovo livello del dipendente
 *  Definire i seguenti metodi statici
 *  - calcolaPaga - accetta un'istanza di dipendente e ne ritorna lo stipendio mensil
 *  - calcolaPaga - accetta un'istanza di dipendente ed un parametro intero con le ore 
 *  di straordinario e ritorna lo stipendio mensile comprensivo di straordinario.
 * */

public class Dipendente {
	private static double stipendioBase = 1000.00;
	private  int matricola;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	private double stipendio;
		
	public Dipendente( int matricola, double importoOrarioStraordinario, 
			Livello livello, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
		this.stipendio = getStipendio();
	}

	public Dipendente(int matricola, Dipartimento dipartimento) {
		this.livello= Livello.OPERAIO;
		this.importoOrarioStraordinario = 30;
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Stipendio: " + this.stipendio + " matricola: " + this.matricola + 
		" importo: " +this.importoOrarioStraordinario + " livello: " + this.livello + 
		" dipartimento: " + this.dipartimento);
	}
	public void promuovi() {
		if(this.livello == Livello.OPERAIO){
			this.livello = Livello.IMPIEGATO;
			this.stipendio = stipendioBase * 1.2;
		}else if(this.livello == Livello.IMPIEGATO) {
			this.livello = Livello.QUADRO;
			this.stipendio = stipendioBase * 1.5;
		}else if(this.livello == Livello.QUADRO){
			this.livello = Livello.DIRIGENTE;
			this.stipendio = stipendioBase * 2;
		}
	}
	
	public double getStipendioBase() {
		return stipendio;
	}
	
	private double getStipendio() {
		if(this.livello == Livello.OPERAIO){
			return stipendioBase;
		}else if(this.livello == Livello.IMPIEGATO) {
			return stipendioBase * 1.2;
		}else if(this.livello == Livello.QUADRO){
			return stipendioBase * 1.5;
		}else if(this.livello == Livello.DIRIGENTE){
			return stipendioBase * 2;
		}
		
		return 0.0;//Dubbio 
	}
	public int getMatricola() {
		return matricola;
	}
	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}
	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}
	public Livello getLivello() {
		return livello;
	}
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
}
