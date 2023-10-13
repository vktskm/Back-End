package com.example.gestione_prenotazioni.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edificio {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEdificio;
	private String name;
	private String address;
	private String city;
	
}
