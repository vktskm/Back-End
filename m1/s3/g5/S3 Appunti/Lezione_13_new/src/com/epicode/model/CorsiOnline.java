package com.epicode.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CorsiOnline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomecorso;
	private Integer ore;
	
	@ManyToMany(mappedBy = "listacorsi")
	List<Utente> listautenti;
	
	public CorsiOnline() {
		super();
	}

	public CorsiOnline(String nomecorso, Integer ore) {
		super();
		this.nomecorso = nomecorso;
		this.ore = ore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomecorso() {
		return nomecorso;
	}

	public void setNomecorso(String nomecorso) {
		this.nomecorso = nomecorso;
	}

	public Integer getOre() {
		return ore;
	}

	public void setOre(Integer ore) {
		this.ore = ore;
	}

	public List<Utente> getListautenti() {
		return listautenti;
	}

	public void setListautenti(List<Utente> listautenti) {
		this.listautenti = listautenti;
	}

	@Override
	public String toString() {
		return "CorsiOnline [id=" + id + ", nomecorso=" + nomecorso + ", ore=" + ore + ", listautenti=" + listautenti
				+ "]";
	}
	
	

}
