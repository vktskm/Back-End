package com.epicode.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class Citta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String provincia;
	private String regione;
	
	// Se voglio una relazione bidirezionale (facoltativo)
	// metto un riferimento della classe A nella classe B
	@OneToMany(mappedBy = "citta")
	private List<Utente> utenti;
	
}
