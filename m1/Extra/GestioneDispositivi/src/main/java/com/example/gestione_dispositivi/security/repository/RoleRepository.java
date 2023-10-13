package com.example.gestione_dispositivi.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestione_dispositivi.security.entity.ERole;
import com.example.gestione_dispositivi.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
