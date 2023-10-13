package com.example.incendio.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sonda implements Isegnale {
    
	private int id ;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;
	private CentroControllo controllo;
	
	public void setLivelloFumo(int livello)
    {
		this.livelloFumo = livello;
		
		if (livelloFumo > 5 )
			segnaleFuoco();
	}
	
	/* Questo metodo sovrascritto dalla classe base implementa l'interfaccia Isegnale. 
	 * Quando il livello di fumo supera 5, questo metodo chiama il metodo attivaControl-
	 * lo() sull'oggetto controllo, passando l'istanza corrente di Sonda come parametro.
	 * In sintesi, la classe Sonda rappresenta un oggetto che può monitorare il livello 
	 * di fumo e attivare un segnale di fuoco attraverso un centro di controllo associato.
	 * */
	@Override 
	public void segnaleFuoco() {
		controllo.attivaControllo(this);
	}
}
