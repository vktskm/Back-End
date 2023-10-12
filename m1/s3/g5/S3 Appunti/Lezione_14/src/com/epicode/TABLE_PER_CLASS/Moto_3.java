package com.epicode.TABLE_PER_CLASS;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Moto_3 extends Veicolo_3 {

	private Integer nposti;
	private String cilindrata;
	
	public Moto_3() {
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
		return "Moto_3 [nposti=" + nposti + ", cilindrata=" + cilindrata + "]";
	}	

}
