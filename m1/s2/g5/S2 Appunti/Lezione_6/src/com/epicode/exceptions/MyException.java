package com.epicode.exceptions;

// Creo una claase MyException personalizzata che va a gestire con la mia logica un eventuale problema del mio codice
// Per creare una Eccezione personalizzata devo estendere la superclasse Exception
public class MyException extends Exception {

	public MyException(String message) {
		// richiamo il costruttore della superclasse Exception e gli passo un messaggio
		super(message);
	}

}
