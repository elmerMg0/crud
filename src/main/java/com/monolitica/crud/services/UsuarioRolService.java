package com.monolitica.crud.services;

import com.monolitica.crud.domain.entities.UsuarioRol;

import java.util.List;

public interface UsuarioRolService {
    List<UsuarioRol> getRolesRolByUsuarioId(Integer usuarioId);
    UsuarioRol save(UsuarioRol usuarioRol);

    void disable (Integer usuarioRolId);
}
