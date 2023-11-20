package com.monolitica.crud.repositories.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monolitica.crud.domain.entities.UsuarioDetail;

public interface UsuarioDetailRepository extends JpaRepository<UsuarioDetail, Integer> {
    
}
