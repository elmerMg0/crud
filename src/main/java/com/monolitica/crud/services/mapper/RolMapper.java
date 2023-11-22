package com.monolitica.crud.services.mapper;

import org.springframework.stereotype.Component;

import com.monolitica.crud.domain.entities.Rol;
import com.monolitica.crud.dto.RolDTO;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{

    @Override
    public RolDTO toDto(Rol rol) {
        RolDTO rolDto = new RolDTO();
        rolDto.setId(rol.getId());
        rolDto.setName(rol.getName());
        return rolDto;
    }

    @Override
    public Rol toEntity(RolDTO dto) {
        Rol rol = new Rol();
        rol.setId(dto.getId());
        rol.setName(dto.getName());
        return rol;
    }
    
}
