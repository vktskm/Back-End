package com.example.gestione_prenotazioni.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.gestione_prenotazioni.classes.Postazione;
import com.example.gestione_prenotazioni.classes.Prenotazione;
import com.example.gestione_prenotazioni.classes.User;


@Repository
public interface PrenotazioneDao extends CrudRepository<Prenotazione,Integer> {
     
	Prenotazione findByUserAndDataPrenotata(User user, LocalDate dataPrenotata);
	List<Prenotazione> findByPostazioneAndDataPrenotata(Postazione postazione, LocalDate dataPrenotata);
}
