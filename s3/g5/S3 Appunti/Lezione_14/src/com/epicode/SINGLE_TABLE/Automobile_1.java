package com.epicode.SINGLE_TABLE;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Auto")
public class Automobile_1 extends Veicolo_1{

	private Integer nporte;
	private String alimentazione;
	
	
	public Automobile_1() {
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
		return "Automobile_1 [nporte=" + nporte + ", alimentazione=" + alimentazione + "]";
	}

}
