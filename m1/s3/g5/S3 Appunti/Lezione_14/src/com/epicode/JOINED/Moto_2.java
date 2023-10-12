package com.epicode.JOINED;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Moto_2 extends Veicolo_2 {

	private Integer nposti;
	private String cilindrata;
	
	public Moto_2() {
		super();
	}

	public Integer getNposti() {
		return nposti;
	}

	public void setNposti(Integer nposti) {
		this.nposti = nposti;
	}

	public String getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(String cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Moto_2 [nposti=" + nposti + ", cilindrata=" + cilindrata + "]";
	}	

}
