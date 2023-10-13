package com.example.gestione_dispositivi.security.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SMARTPHONE")
public class Smartphone extends Dispositivo{

	public Smartphone(){
		this.setStato(Stato.DISPONIBILE);
		// TODO Auto-generated constructor stub
	}
	
	
}
