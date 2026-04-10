package com.teacompanion.TEACompanion_API.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    protected Integer id_usuario;
    private String username;
    private String password;
    protected String nome;
    protected String email;
}
