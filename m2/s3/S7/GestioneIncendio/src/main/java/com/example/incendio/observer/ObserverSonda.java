package com.example.incendio.observer;

import java.util.Observable;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class ObserverSonda extends Observable{
	
	private int id;
    private double latitudine;
    private double longitudine;
    private int livelloFumo;
    
    public ObserverSonda( int id, double latitudine, double longitudine) {
    	super();
    	this.id = id;
    	this.latitudine = latitudine;
    	this.longitudine = longitudine;
    	this.livelloFumo = 0;
    }
   
    
    
    public void setLivelloFumo(int livello) {
        this.livelloFumo = livello;
        if (livelloFumo > 5) {
        	notificaSegnale();
        }
    }
    
    private void notificaSegnale() {
        setChanged();
        notifyObservers(this);
    }
    
    /* Questo metodo privato è chiamato quando il livello di fumo supera 5. 
     * setChanged() viene chiamato per indicare che lo stato è cambiato. 
     * Successivamente, notifyObservers(this) è chiamato per notificare tutti gli osservatori 
     * che il soggetto (la sonda) è stato aggiornato, passando se stesso come argomento.
     * In sintesi, la classe ObserverSonda rappresenta una sonda osservabile che tiene traccia 
     * dei suoi attributi e notifica gli osservatori registrati quando il livello di fumo supe-
     * ra una soglia. Gli osservatori, che saranno oggetti che implementano l'interfaccia Observer, 
     * potranno reagire al cambiamento dello stato della sonda.
     * */


}
