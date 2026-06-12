package com.teacompanion.TEACompanion_API.DTO.Individuo;

import lombok.Data;

@Data
public class IndividuoDTO {
    private Integer id_usuario;
    private String nome;
    private String email;
    // Indivíduos podem não precisar de username/password se forem apenas registros
    // Mas se precisarem de acesso, os campos estariam aqui. 
    // Por enquanto, manteremos o padrão de UsuarioDTO simplificado para o cadastro.
}
