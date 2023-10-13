package com.example.incendio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.incendio.factory.CentroControllo;
import com.example.incendio.factory.FactoryCentroControllo;
import com.example.incendio.factory.FactorySonda;
import com.example.incendio.factory.Sonda;
import com.example.incendio.observer.ObserverCentroControllo;
import com.example.incendio.observer.ObserverSonda;

@SpringBootApplication
public class GestioneIncendioApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendioApplication.class, args);
		
		
		FactorySonda sondaFactory = new FactorySonda();
		FactoryCentroControllo centroDiControlloFactory = new FactoryCentroControllo();
		CentroControllo controllo1 = centroDiControlloFactory.crea();
		
		Sonda sonda1 = sondaFactory.creaSonda(1, 87.823, -13.112);
		Sonda sonda2 = sondaFactory.creaSonda(2, -12.245, 81.147);
		Sonda sonda3 = sondaFactory.creaSonda(3, 12.045, -11.147);
		
		sonda1.setControllo(controllo1);
		sonda2.setControllo(controllo1);
		sonda3.setControllo(controllo1);
		sonda1.setLivelloFumo(6);
		sonda2.setLivelloFumo(8);
		sonda3.setLivelloFumo(3);
		
		
		ObserverSonda sonda4 = new ObserverSonda(4, 17.322, 19.402);
		ObserverSonda sonda5 = new ObserverSonda(5, -13.211, -21.302);
		ObserverSonda sonda6 = new ObserverSonda(6, 43.211, 21.302);
		ObserverCentroControllo controllo2 = new ObserverCentroControllo();
		
		sonda4.addObserver(controllo2);
		sonda5.addObserver(controllo2);
		sonda6.addObserver(controllo2);
		sonda4.setLivelloFumo(7);
		sonda5.setLivelloFumo(1);
		sonda6.setLivelloFumo(8);
	}

}
