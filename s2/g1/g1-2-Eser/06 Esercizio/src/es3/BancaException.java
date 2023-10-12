package es3;

/* Creare un nuovo tipo di eccezione: la classe BancaException sottoclasse 
 * della classe Exception avente l’attributo message di tipo stringa. 
 * Scrivere il costruttore con un parametro di tipo stringa, dopo aver 
 * richiamato il costruttore della superclasse passando il parametro 
 * impostare il valore dell’attributo message uguale al parametro. 
 * Ridefinire il metodo toString che restituisce un stringa, il metodo 
 * restituisce il valore di message.
 * */

public class BancaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public BancaException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}

}