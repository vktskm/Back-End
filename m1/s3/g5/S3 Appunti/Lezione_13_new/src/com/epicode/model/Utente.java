package com.epicode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epicode.enumerated.Type;

@Entity
@Table(name = "utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String nome;
	
	@Column(name = "lastname", nullable = false)
	private String cognome;
	
	@Column(name = "age", nullable = false)
	private Integer anni;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	// Relazione @OneToOne unidirezionale
	// Cascade propaga tutte le operazioni alle tabelle in relazione con utente
	// FetchType Eager carica tutti i dati contemporaneamente, 
	// Lazy carica i dati delle relazioni posticipati 
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Smartphone smartphone;
	
	// Relazione @ManyToOne unidirezionale
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Citta citta;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CorsiOnline> listacorsi;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type tipo;

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, Integer anni, String email, Smartphone smartphone, Citta citta,
			List<CorsiOnline> listacorsi, Type tipo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
		this.email = email;
		this.smartphone = smartphone;
		this.citta = citta;
		this.listacorsi = listacorsi;
		this.tipo = tipo;
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

	public Smartphone getSmartphone() {
		return smartphone;
	}

	public void setSmartphone(Smartphone smartphone) {
		this.smartphone = smartphone;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public List<CorsiOnline> getListacorsi() {
		return listacorsi;
	}

	public void setListacorsi(List<CorsiOnline> listacorsi) {
		this.listacorsi = listacorsi;
	}

	public Type getTipo() {
		return tipo;
	}

	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", anni=" + anni + ", email=" + email
				+ ", smartphone=" + smartphone + ", citta=" + "" + ", listacorsi=" + "" + ", tipo=" + tipo
				+ "]";
	}

	

	

}
