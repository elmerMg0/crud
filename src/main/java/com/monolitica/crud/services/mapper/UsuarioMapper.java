package com.monolitica.crud.services.mapper;

import org.springframework.stereotype.Component;

import com.monolitica.crud.domain.entities.Usuario;
import com.monolitica.crud.dto.UsuarioDTO;

@Component
public class UsuarioMapper implements CustomMapper<UsuarioDTO, Usuario>{

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDTO =  new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setEmail(usuario.getEmail());
        return usuarioDTO;
    }


    public UsuarioDTO toDtoDetailed(Usuario usuario) {
        UsuarioDTO usuarioDTO =  new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setEmail(usuario.getEmail());

        if (usuario.getUsuarioDetail() != null) {
            usuarioDTO.setFirstName(usuario.getUsuarioDetail().getFirstName());
            usuarioDTO.setLastName(usuario.getUsuarioDetail().getLastName());
            usuarioDTO.setAge(usuario.getUsuarioDetail().getAge());
            usuarioDTO.setBirthdate(usuario.getUsuarioDetail().getBirthDay());

        } else {
            usuarioDTO.setFirstName("Not assigned yet");
            usuarioDTO.setLastName("Not assigned yet");
        }
        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setEmail(dto.getEmail());
        return usuario;
    }   
    
}
