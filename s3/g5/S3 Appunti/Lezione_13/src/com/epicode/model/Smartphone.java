package com.epicode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Smartphone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modello;
	
	// Se voglio una relazione bidirezionale (facoltativo)
	// metto un riferimento della classe A nella classe B
	@OneToOne(mappedBy = "smartphone") // mappedBy conterrà un riferimento alla proprietà della classe A
	private Utente utente;

	public Smartphone() {
		super();
	}

	public Smartphone(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
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
	
	

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", marca=" + marca + ", modello=" + modello + "]";
	}
	
	

}
