package model;

import javax.persistence.Entity;

@Entity
public class Concerto extends Evento {

	private GenereConcerto genere;
	private Boolean inStreaming;
	
	public GenereConcerto getGenere() {
		return genere;
	}
	public void setGenere(GenereConcerto genere) {
		this.genere = genere;
	}
	public Boolean getInStreaming() {
		return inStreaming;
	}
	public void setInStreaming(Boolean inStreaming) {
		this.inStreaming = inStreaming;
	}
	
	
	
}
