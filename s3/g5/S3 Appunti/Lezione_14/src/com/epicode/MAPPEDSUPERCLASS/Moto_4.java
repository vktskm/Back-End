package com.epicode.MAPPEDSUPERCLASS;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Moto_4 extends Veicolo_4 {

	private Integer nposti;
	private String cilindrata;
	
	public Moto_4() {
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
		return "Moto_4 [nposti=" + nposti + ", cilindrata=" + cilindrata + "]";
	}	

}
