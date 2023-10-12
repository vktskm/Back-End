package com.epicode.JOINED;

import javax.persistence.Entity;

@Entity
public class Automobile_2 extends Veicolo_2{

	private Integer nporte;
	private String alimentazione;
	
	
	public Automobile_2() {
		super();
	}

	public Integer getNporte() {
		return nporte;
	}

	public void setNporte(Integer nporte) {
		this.nporte = nporte;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	@Override
	public String toString() {
		return "Automobile_2 [nporte=" + nporte + ", alimentazione=" + alimentazione + "]";
	}

}
