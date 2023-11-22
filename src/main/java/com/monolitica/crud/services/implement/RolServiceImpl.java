package com.monolitica.crud.services.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.monolitica.crud.domain.entities.Rol;
import com.monolitica.crud.dto.RolDTO;
import com.monolitica.crud.repositories.spring.data.RolRepository;
import com.monolitica.crud.services.RolService;
import com.monolitica.crud.services.mapper.RolMapper;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;
    
    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> listRoles() {
        return rolRepository.findAll()
                    .stream()
                    .map(rolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RolDTO save(RolDTO rolDto) {
        Rol rol = rolRepository.save(rolMapper.toEntity(rolDto));
        return rolMapper.toDto(rol);
    }

    @Override
    public Optional<RolDTO> getRolById(Integer rolId) {
        return rolRepository.findById(rolId).map(rolMapper::toDto);
    }

    @Override
    public void delete(Integer rolId) {
        rolRepository.deleteById(rolId);
    }
    
}
