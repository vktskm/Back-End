package com.epicode.MAPPEDSUPERCLASS;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Automobile.findAll", query = "SELECT a FROM Automobile_4 a") // dove a sarà l'ogg di tipo Automobile che mi verrà restituito dalla query
@NamedQuery(name = "Automobile.findMarca", query = "SELECT a FROM Automobile_4 a WHERE a.marca LIKE :marca_auto")
public class Automobile_4 extends Veicolo_4{

	private Integer nporte;
	private String alimentazione;
	
	
	public Automobile_4() {
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
		return "Automobile_4 [nporte=" + nporte + ", alimentazione=" + alimentazione + ", getId()=" + getId()
				+ ", getMarca()=" + getMarca() + ", getModello()=" + getModello() + "]";
	}

	

}
