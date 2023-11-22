package com.monolitica.crud.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monolitica.crud.dto.UsuarioDTO;
import com.monolitica.crud.services.UsuarioService;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
@RestController
@RequestMapping ("/v1/usuarios")
@Validated
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listUsers (@RequestParam(required = false, defaultValue = "false") boolean detailed){
        if (detailed) {
            return ResponseEntity.ok().body(usuarioService.listUserDetails());
        } else {
            return ResponseEntity.ok().body(usuarioService.listUsers());
        }
    }   
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(usuarioService.getUsuarioById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

      @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody final UsuarioDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new user cannot already have an id.");
        }

        UsuarioDTO usuarioDTO = usuarioService.save(dto);

        return ResponseEntity.created(new URI("/v1/students/" + usuarioDTO.getId())).body(usuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> editUser(@RequestBody final UsuarioDTO dto,
                                                @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity
                .ok()
                .body(this.usuarioService.save(dto));
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
