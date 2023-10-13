package com.example.incendio.factory;

import lombok.Data;

@Data
public class CentroControllo implements Icontrollo{
     
	@Override
	public void attivaControllo(Sonda s) {
       
		int id = s.getId();
		double longitudine = s.getLongitudine();
		double latitudine = s.getLatitudine();
		int livello = s.getLivelloFumo();
		String messaggio = "Sonda: "+ id + " Lon: " + longitudine + " Lat: " + latitudine + "Livello " + livello;
		String url_segnale = "http://host/alarm?segnaleId="+id+"&lat="+latitudine+"&lon="+longitudine+"&smokeLevel="+livello;
        System.out.println(messaggio );
        System.out.println(url_segnale);
	
	}
	
}
