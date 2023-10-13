package com.example.gestione_dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.gestione_dispositivi.security.entity.Dispositivo;

public interface DispositivoDao extends CrudRepository <Dispositivo, Long> {

}
