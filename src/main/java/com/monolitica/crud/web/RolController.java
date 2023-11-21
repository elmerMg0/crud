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
import org.springframework.web.bind.annotation.RestController;

import com.monolitica.crud.dto.RolDTO;
import com.monolitica.crud.services.RolService;

@RestController
@RequestMapping ("/v1/roles")
public class RolController {
    private final RolService rolservice;

    public RolController(RolService rolservice) {
        this.rolservice = rolservice;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listRoles() {
        return ResponseEntity.ok().body(rolservice.listRoles());
    }



    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRoleById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(rolservice.getRolById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody final RolDTO rolDto) throws URISyntaxException {
         if (rolDto.getId() != null) {
            throw new IllegalArgumentException("I new rol cannot be created, because it already have an id.");
        }

        RolDTO rolDB = rolservice.save(rolDto);

        return ResponseEntity.created(new URI("/v1/students/" + rolDB.getId())).body(rolDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        rolservice.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editRol(@RequestBody final RolDTO dto,
                                                @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid rol id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity
                .ok()
                .body(this.rolservice.save(dto));
    }

}
