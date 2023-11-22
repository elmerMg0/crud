package com.monolitica.crud.services;

import com.monolitica.crud.domain.entities.UsuarioRol;
import com.monolitica.crud.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioRolService {
    List<UsuarioRol> getRolesRolByUsuarioId(Integer usuarioId);
    UsuarioRol save(UsuarioRol usuarioRol);

    void disable (Integer usuarioRolId);
}
