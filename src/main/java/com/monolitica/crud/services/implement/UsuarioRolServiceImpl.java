package com.monolitica.crud.services.implement;

import com.monolitica.crud.domain.entities.UsuarioRol;
import com.monolitica.crud.repositories.spring.data.UsuarioRolRepositoty;
import com.monolitica.crud.services.UsuarioRolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    private final UsuarioRolRepositoty usuarioRolRepositoty;

    public UsuarioRolServiceImpl(UsuarioRolRepositoty usuarioRolRepositoty) {
        this.usuarioRolRepositoty = usuarioRolRepositoty;
    }

    @Override
    public List<UsuarioRol> getRolesRolByUsuarioId(Integer usuarioId) {
        return usuarioRolRepositoty.findAllByUsuario_IdOrderById(usuarioId);
    }

    @Override
    public UsuarioRol save(UsuarioRol usuarioRol) {
        return usuarioRolRepositoty.save(usuarioRol);
    }

    @Override
    public void disable(Integer usuarioRolId) {
        Optional<UsuarioRol> optionalUsuarioRol = usuarioRolRepositoty.findById(usuarioRolId);
        if (optionalUsuarioRol.isPresent()) {
            UsuarioRol usuarioRol = optionalUsuarioRol.get();
            usuarioRol.setActive(false);
            usuarioRolRepositoty.save(usuarioRol);
        } else {
            throw new IllegalArgumentException("User not found with id: " + usuarioRolId);
        }
    }
}
