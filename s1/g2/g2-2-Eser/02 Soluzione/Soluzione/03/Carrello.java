package it.epicode.exercises.week1.giorno4;

public class Carrello {
	
	private Cliente cliente;
	private Articolo[] elencoArticoli;
	private double totaleCostoArticoli;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Articolo[] getElencoArticoli() {
		return elencoArticoli;
	}
	public void setElencoArticoli(Articolo[] elencoArticoli) {
		this.elencoArticoli = elencoArticoli;
	}
	public double getTotaleCostoArticoli() {
		return totaleCostoArticoli;
	}
	public void setTotaleCostoArticoli(double totaleCostoArticoli) {
		this.totaleCostoArticoli = totaleCostoArticoli;
	}

}
