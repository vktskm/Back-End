package model;

import javax.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento {
	
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente; // [null se pareggio]
	private Integer numeroGolSquadraDiCasa = 0;
	private Integer numeroGolSquadraOspite = 0;
	
	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}
	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}
	public String getSquadraOspite() {
		return squadraOspite;
	}
	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}
	public String getSquadraVincente() {
		return squadraVincente;
	}
	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}
	public Integer getNumeroGolSquadraDiCasa() {
		return numeroGolSquadraDiCasa;
	}
	public void setNumeroGolSquadraDiCasa(Integer numeroGolSquadraDiCasa) {
		this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
	}
	public Integer getNumeroGolSquadraOspite() {
		return numeroGolSquadraOspite;
	}
	public void setNumeroGolSquadraOspite(Integer numeroGolSquadraOspite) {
		this.numeroGolSquadraOspite = numeroGolSquadraOspite;
	}
	
	
}
