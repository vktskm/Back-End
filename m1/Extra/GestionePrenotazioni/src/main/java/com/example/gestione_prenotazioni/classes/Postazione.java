package com.example.gestione_prenotazioni.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postazione {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPostazione;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	private Integer numeroMassimoOccup;
	@ManyToOne
	private Edificio edificio;
	
	
}
