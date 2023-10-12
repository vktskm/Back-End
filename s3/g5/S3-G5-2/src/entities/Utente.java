package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utenti")
public class Utente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartaId;
	private String nome;
	private String cognome;
	private LocalDate datanascita;
	
	public Utente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utente(String nome, String cognome, LocalDate datanascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = datanascita;
	}

	public Integer getCartaId() {
		return cartaId;
	}

	public void setCartaId(Integer cartaId) {
		this.cartaId = cartaId;
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

	public LocalDate getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(LocalDate datanascita) {
		this.datanascita = datanascita;
	}

	@Override
	public String toString() {
		return "Utente [cartaId=" + cartaId + ", nome=" + nome + ", cognome=" + cognome + ", datanascita=" + datanascita
				+ "]";
	}	
	
    
}
