package com.monolitica.crud.repositories.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monolitica.crud.domain.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    
}
