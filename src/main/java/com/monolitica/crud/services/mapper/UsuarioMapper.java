package com.monolitica.crud.services.mapper;

import com.monolitica.crud.dto.UsuarioDetailDTO;
import org.springframework.stereotype.Component;

import com.monolitica.crud.domain.entities.Usuario;
import com.monolitica.crud.dto.UsuarioDTO;

import java.sql.Date;

@Component
public class UsuarioMapper implements CustomMapper<UsuarioDTO, Usuario>{

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDTO =  new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        //usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setEmail(usuario.getEmail());
        return usuarioDTO;
    }


    public UsuarioDTO toDtoDetailed(Usuario usuario) {
        UsuarioDTO usuarioDTO =  new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        // usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setEmail(usuario.getEmail());

        UsuarioDetailDTO usuarioDetailDTO = new UsuarioDetailDTO();

        if (usuario.getUsuarioDetail() != null) {
            usuarioDetailDTO.setFirstName(usuario.getUsuarioDetail().getFirstName());
            usuarioDetailDTO.setLastName(usuario.getUsuarioDetail().getLastName());
            usuarioDetailDTO.setAge(usuario.getUsuarioDetail().getAge());
            usuarioDetailDTO.setBirthdate(usuario.getUsuarioDetail().getBirthDay());

            usuarioDTO.setUsuarioDetailDTO(usuarioDetailDTO);

//            usuarioDTO.setFirstName(usuario.getUsuarioDetail().getFirstName());
//            usuarioDTO.setLastName(usuario.getUsuarioDetail().getLastName());
//            usuarioDTO.setAge(usuario.getUsuarioDetail().getAge());
//            usuarioDTO.setBirthdate(usuario.getUsuarioDetail().getBirthDay());

        } else {
            usuarioDetailDTO.setFirstName("No assigned yet");
            usuarioDetailDTO.setLastName("No assigned yet");
            usuarioDetailDTO.setAge(0);
            //usuarioDetailDTO.setBirthdate(Date.valueOf("0000:00:00 00:00:00"));

            usuarioDTO.setUsuarioDetailDTO(usuarioDetailDTO);
//            usuarioDTO.setFirstName("Not assigned yet");
//            usuarioDTO.setLastName("Not assigned yet");
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
