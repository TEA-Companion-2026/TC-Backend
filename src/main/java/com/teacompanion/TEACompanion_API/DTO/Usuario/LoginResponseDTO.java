package com.teacompanion.TEACompanion_API.DTO.Usuario;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String nome;
    private String email;
    private String token;
}
