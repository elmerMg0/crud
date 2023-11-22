package com.monolitica.crud.services;

import java.util.List;
import java.util.Optional;

import com.monolitica.crud.dto.UsuarioDTO;

public interface UsuarioService {
    List<UsuarioDTO> listUsers();
    List<UsuarioDTO> listUserDetails();
    UsuarioDTO save(UsuarioDTO dto);
    Optional <UsuarioDTO> getUsuarioById(Integer id);
    void delete (Integer id);

}
