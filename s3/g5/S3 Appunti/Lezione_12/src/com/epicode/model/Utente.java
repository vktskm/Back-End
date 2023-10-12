package com.epicode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Ogni Entity deve avere obbligatoriamente una annotation 
// @Entity sulla classe che si vuole rendere persistente
// Deve avere una annotation @Id sul campo che definiamo come Primary Key
// Dobbiamo definire un costruttore di Default (Quello senza parametri)

@Entity
@Table(name = "utenti") // Facoltativo -> indica il nome della tabella da generare e da collegare alla classe Utente
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Facoltativo -> Genera un valore automatico per la primary Key
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String nome;
	@Column(name = "lastname", nullable = false)
	private String cognome;
	@Column(name = "age", nullable = false)
	private Integer anni;
	@Column(nullable = false, unique = true)
	private String email;	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type tipo;

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, Integer anni, String email, Type type) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
		this.email = email;
		this.tipo = type;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getAnni() {
		return anni;
	}

	public void setAnni(Integer anni) {
		this.anni = anni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Type getType() {
		return tipo;
	}

	public void setType(Type type) {
		this.tipo = type;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", anni=" + anni + ", email=" + email
				+ ", type=" + tipo + "]";
	}

}
