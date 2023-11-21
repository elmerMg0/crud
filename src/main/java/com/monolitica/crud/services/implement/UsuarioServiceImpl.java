package com.monolitica.crud.services.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.monolitica.crud.domain.entities.Usuario;
import com.monolitica.crud.domain.entities.UsuarioDetail;
import com.monolitica.crud.dto.UsuarioDTO;
import com.monolitica.crud.repositories.spring.data.UsuarioDetailRepository;
import com.monolitica.crud.repositories.spring.data.UsuarioRepository;
import com.monolitica.crud.services.UsuarioService;
import com.monolitica.crud.services.mapper.UsuarioMapper;

@Service
public class UsuarioServiceImpl implements UsuarioService  {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioDetailRepository usuarioDetailRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, UsuarioDetailRepository usuarioDetailRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.usuarioDetailRepository = usuarioDetailRepository;
    }

    @Override
    public List<UsuarioDTO> listUsers(){
        return usuarioRepository.findAll()
                    .stream()
                    .map(usuarioMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> listUserDetails(){
        return usuarioRepository.findAll()
                    .stream()
                    .map(usuarioMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO save(UsuarioDTO dto){
        Usuario usuario = usuarioRepository.save(usuarioMapper.toEntity(dto));
        /* Validar si existe los parametros de usuarioDetail */
        usuarioDetailRepository.save(new UsuarioDetail(dto.getFirstName(), dto.getLastName(),dto.getAge(), dto.getBirthdate(), usuario));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public Optional <UsuarioDTO> getUsuarioById(Integer id){
        return usuarioRepository.findById(id).map(usuarioMapper::toDtoDetailed);
    }

    @Override
    public void delete (Integer id){
        usuarioRepository.deleteById(id);
    }
}
