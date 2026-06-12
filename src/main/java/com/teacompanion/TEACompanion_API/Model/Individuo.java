package com.teacompanion.TEACompanion_API.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INDIVIDUO")
public class Individuo extends Usuario {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Indivíduos não possuem permissões de acesso ao sistema
        return List.of();
    }
}
