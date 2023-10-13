package com.epicode.GodfathersPizza.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Tavolo {
	
	private Integer numero;
	private Integer numeroMassimoCoperti;
	private Boolean occupato = false;
	
	public void setOccupato(Boolean occupato) {
		this.occupato = occupato;
	}

}
