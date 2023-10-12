package com.epicode.model;

import java.util.ArrayList;
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
	private List<Utente> utenti = new ArrayList<Utente>();

	public Citta(String nome, String provincia, String regione) {
		super();
		this.nome = nome;
		this.provincia = provincia;
		this.regione = regione;
	}

	public Citta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return "Citta [id=" + id + ", nome=" + nome + ", provincia=" + provincia + ", regione=" + regione + ", utenti="
				+ utenti + "]";
	}
	
	
	
}
