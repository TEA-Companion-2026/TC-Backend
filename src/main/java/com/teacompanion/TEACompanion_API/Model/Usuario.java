package com.teacompanion.TEACompanion_API.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue
    protected Integer id_usuario;
    private String username;
    private String password;
    protected String nome;
    protected String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
