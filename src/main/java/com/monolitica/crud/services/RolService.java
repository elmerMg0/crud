package com.monolitica.crud.services;

import java.util.List;
import java.util.Optional;

import com.monolitica.crud.dto.RolDTO;

public interface RolService {
    List<RolDTO> listRoles();
    RolDTO save(RolDTO rol);
    Optional<RolDTO> getRolById(Integer rolId);
    void delete(Integer rolId);
}
