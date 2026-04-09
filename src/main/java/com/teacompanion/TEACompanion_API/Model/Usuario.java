package com.teacompanion.TEACompanion_API.Model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Usuario {
    protected Integer id_usuario;
    private String username;
    private String password;
    protected String nome;
    protected String email;
}
