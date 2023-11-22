package com.monolitica.crud.repositories.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monolitica.crud.domain.entities.UsuarioRol;

public interface UsuarioRolRepositoty extends JpaRepository<UsuarioRol, Integer> {
    List<UsuarioRol> findAllByUsuario_IdOrderById(Integer usuarioId);
}
