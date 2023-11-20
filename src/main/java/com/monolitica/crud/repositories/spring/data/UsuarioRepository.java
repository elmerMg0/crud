package com.monolitica.crud.repositories.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monolitica.crud.domain.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}