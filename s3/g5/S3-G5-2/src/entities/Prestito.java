package entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "findActiveByCode", query = "SELECT p.elementoPrestato FROM Prestito p JOIN p.utente u WHERE u.cartaId = :cartaId AND p.dataRestituzioneEffettiva IS NULL")
@NamedQuery(name = "findLateActive", query = "SELECT p.elementoPrestato FROM Prestito p WHERE p.dataRestituzionePrevista < p.dataRestituzioneEffettiva")
public class Prestito {
	
	@Id
	@GeneratedValue
    private Integer idPrestito;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Utente utente;
	@ManyToOne(cascade = CascadeType.ALL)
	private Editore elementoPrestato;
	
	private LocalDate dataInizioPrestito;
	private LocalDate dataRestituzionePrevista; 
	private LocalDate dataRestituzioneEffettiva;
	
	public Prestito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prestito(Utente utente, Editore elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
   }

	public Integer getIdPrestito() {
		return idPrestito;
	}

	public void setIdPrestito(Integer idPrestito) {
		this.idPrestito = idPrestito;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Editore getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(Editore elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}

	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [idPrestito=" + idPrestito + ", utente=" + utente + ", elementoPrestato=" + elementoPrestato
				+ ", dataInizioPrestito=" + dataInizioPrestito + ", dataRestituzionePrevista="
				+ dataRestituzionePrevista + ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}
		
}
