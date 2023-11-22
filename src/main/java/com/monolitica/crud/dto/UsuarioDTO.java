package com.monolitica.crud.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 3234234545454L;

    private Integer id;

    @NotNull()
    @Size(min = 5, max = 10)
    private String username;

    
    private String password;

    @Email( message = "Invalid email")
    private String email;


    private UsuarioDetailDTO usuarioDetailDTO;

    private String created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public UsuarioDetailDTO getUsuarioDetailDTO (){
        return usuarioDetailDTO;
    }
    public void setUsuarioDetailDTO (UsuarioDetailDTO usuarioDetailDTO){
        this.usuarioDetailDTO = usuarioDetailDTO;
    }
}

