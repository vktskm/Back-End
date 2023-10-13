package com.example.incendio.factory;


/* Una factory (fabbrica) è un design pattern creazionale che fornisce un'interfaccia per 
 * creare oggetti in una classe separata, permettendo di nascondere i dettagli specifici 
 * di creazione e di gestione delle istanze. Questo approccio può migliorare la modularità 
 * del codice e facilitare la manutenzione, poiché i dettagli di creazione sono isolati in 
 * una classe dedicata.
 * */

public class FactorySonda implements IFactorySonda {
	
	@Override
	public Sonda creaSonda( int id, double lat, double lon) {
		Sonda sonda = new Sonda();
		sonda.setId(id);
		sonda.setLatitudine(lat);
		sonda.setLongitudine(lon);
		return sonda;
	}
    
	/* Questa classe implementa l'interfaccia IFactorySonda, che probabilmente contiene un solo 
	 * metodo astratto creaSonda(). Questo metodo prende come parametri l'ID della sonda, la la-
	 * titudine e la longitudine, e restituisce un'istanza di oggetto Sonda appena creata con gli 
	 * attributi specificati.
	 * Quindi, quando si chiama il metodo creaSonda() su un'istanza di FactorySonda, verrà resti-
	 * tuita un'istanza di Sonda con l'ID, la latitudine e la longitudine forniti.
	 * In sostanza, questa factory astrae il processo di creazione di oggetti Sonda, nascondendo 
	 * i dettagli di creazione all'esterno delle parti che utilizzano l'oggetto. Ciò può essere 
	 * utile quando si vogliono mantenere tali dettagli nascosti e centralizzati in una classe 
	 * dedicata, migliorando così l'organizzazione e la manutenzione del codice.
	 * */
}
