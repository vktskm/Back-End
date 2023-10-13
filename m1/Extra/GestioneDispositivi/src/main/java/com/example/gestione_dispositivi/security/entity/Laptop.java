package com.example.gestione_dispositivi.security.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LAPTOP")
public class Laptop extends Dispositivo {

	public Laptop(){
		this.setStato(Stato.DISPONIBILE);
		// TODO Auto-generated constructor stub
	}
}
