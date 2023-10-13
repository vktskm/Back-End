package com.epicode.introSpring.DipendencyInjection;

public class EuropeanAddress implements IAddress  {
	
	private String citta;
	private String via;
	private String provincia;
	
	public EuropeanAddress(String citta, String via, String provincia) {
		super();
		this.citta = citta;
		this.via = via;
		this.provincia = provincia;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "EuropeanAddress [citta=" + citta + ", via=" + via + ", provincia=" + provincia + "]";
	}
	
	

}
