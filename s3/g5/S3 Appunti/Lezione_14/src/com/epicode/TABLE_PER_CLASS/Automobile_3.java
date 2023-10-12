package com.epicode.TABLE_PER_CLASS;

import javax.persistence.Entity;

@Entity
public class Automobile_3 extends Veicolo_3{

	private Integer nporte;
	private String alimentazione;
	
	
	public Automobile_3() {
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
		return "Automobile_3 [nporte=" + nporte + ", alimentazione=" + alimentazione + "]";
	}

}
