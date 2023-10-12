package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Editore")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "searchByISBN", query = "SELECT pc FROM Editore pc WHERE pc.isbn = :isbn")
@NamedQuery(name = "searchByYear", query = "SELECT pc FROM Editore pc WHERE pc.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "searchByTitle", query = "SELECT pc FROM Editore pc WHERE pc.titolo LIKE CONCAT('%', :titolo, '%')")
public class Editore {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;
	private String titolo;
	private Integer annoPubblicazione;
	private Integer pagine;
	
	public Editore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Editore(String titolo, Integer annoPubblicazione, Integer pagine) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.pagine = pagine;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getPagine() {
		return pagine;
	}

	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}

	@Override
	public String toString() {
		return "Editore [isbn=" + isbn + ", titolo=" + titolo + 
				", annoPubblicazione=" + annoPubblicazione + 
				", pagine="+ pagine + "]";
	}
	
	
}
