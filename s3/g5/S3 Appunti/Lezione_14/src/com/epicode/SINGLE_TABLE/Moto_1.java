package com.epicode.SINGLE_TABLE;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Moto")
public class Moto_1 extends Veicolo_1 {

	private Integer nposti;
	private String cilindrata;
	
	public Moto_1() {
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
		return "Moto_1 [nposti=" + nposti + ", cilindrata=" + cilindrata + "]";
	}	

}
