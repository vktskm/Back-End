package com.epicode.TABLE_PER_CLASS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "veicolo_3")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Veicolo_3 {
	
	@Id
	@GeneratedValue()
	private Long id;
	private String marca;
	private String modello;

	public Veicolo_3() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	@Override
	public String toString() {
		return "Veicolo_3 [id=" + id + ", marca=" + marca + ", modello=" + modello + "]";
	}

}
