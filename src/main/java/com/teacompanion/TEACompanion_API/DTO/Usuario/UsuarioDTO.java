package com.teacompanion.TEACompanion_API.DTO.Usuario;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id_usuario;
    private String username;
    private String password;
    private String nome;
    private String email;
}
