package com.example.gestione_prenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gestione_prenotazioni.classes.Postazione;
import com.example.gestione_prenotazioni.classes.TipoPostazione;

@Repository
public interface PostazioneDao extends CrudRepository<Postazione, Integer>{
   
	@Query("SELECT p FROM Postazione p WHERE p.tipo LIKE :tipo AND p.edificio.city LIKE :city")
    List<Postazione> findByTipoAndCityEdificio(@Param("tipo") TipoPostazione tipo, @Param("city") String city);	
}
