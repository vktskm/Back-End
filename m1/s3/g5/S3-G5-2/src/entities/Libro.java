package entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery (name = "searchByAuthor", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
public class Libro extends Editore {
	
	private String autore;
	private String genere;
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Libro(String titolo, Integer annoPubblicazione, Integer pagine,
			     String autore, String genere) {
		super(titolo, annoPubblicazione, pagine);
		this.autore = autore;
		this.genere = genere;			
	}
	
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		return "Libro " + super.toString()+ " [autore=" + autore + ", genere=" + genere + "]";
	}
	
	 
    	
	

}
