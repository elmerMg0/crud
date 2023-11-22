package com.monolitica.crud.web;

import com.monolitica.crud.domain.entities.UsuarioRol;
import com.monolitica.crud.services.UsuarioRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios/{id}/roles")
public class UsuarioRolController {
    private final UsuarioRolService usuarioRolService;


    public UsuarioRolController(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }


    @GetMapping()
    public ResponseEntity<List<UsuarioRol>> listRolesByUsuario(@PathVariable final Integer id) {
        return ResponseEntity.ok().body(usuarioRolService.getRolesRolByUsuarioId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioRol> create(@RequestBody final UsuarioRol usuarioRol) throws URISyntaxException {
        if (usuarioRol.getId() != null) {
            throw new IllegalArgumentException("I new usuario rol cannot already have an id.");
        }
        usuarioRol.setCreatedAt(LocalDateTime.now());
        UsuarioRol usuarioRolDB = usuarioRolService.save(usuarioRol);

        return ResponseEntity
                .created(new URI("/v1/usuarios/" + usuarioRolDB.getUsuario().getId() + "/usuariorol/" + usuarioRolDB.getId()))
                .body(usuarioRolDB);
    }
    @PatchMapping()
    public ResponseEntity<Void> disableRol (@PathVariable final Integer id){
        usuarioRolService.disable(id);
        return ResponseEntity.noContent().build();
    }
}
