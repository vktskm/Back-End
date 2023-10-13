package com.example.incendio.observer;

import java.util.Observable;
import java.util.Observer;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class ObserverCentroControllo implements Observer{

	@Override
	public void update(Observable o, Object sonda) {
		// TODO Auto-generated method stub
		
		ObserverSonda s = (ObserverSonda) o;
		int id = s.getId();
		double latitudine = s.getLatitudine();
		double longitudine = s.getLongitudine();
		int livello = s.getLivelloFumo();	
		
		String messaggio = "Sonda: "+ id + " Lon: " + longitudine + " Lat: " + latitudine + "Livello " + livello;
		String url_segnale = "http://host/alarm?segnaleId="+id+"&lat="+latitudine+"&lon="+longitudine+"&smokeLevel="+livello;
		
		
        System.out.println(messaggio);
        System.out.println(url_segnale);
        
        //SondaProxy sp = new SondaProxy(s);
		
	}

}
